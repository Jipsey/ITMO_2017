package MultiThread.QueueTreadingWords;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;
import static Task_Collections_Map.WordPeace.readWords;
import static Task_Collections_Map.WordPeace.topForMap;


public class QueueThreadWord {
        private static int num = 0;           // счётчик слов в книге
        private    Queue<Map<String, Integer>> resultQueue = new ConcurrentLinkedQueue<>();


    private static void increment(){
        num++;
    }

    public static void main(String[] args) throws Exception {

        QueueThreadWord twp = new QueueThreadWord();

        int numProcessors =Runtime.getRuntime().availableProcessors();
        System.out.printf("У нас %s ядра процесссора!\n",numProcessors);

        // создаём список из слов из книги
        List<String> words = readWords(new File("C:\\Education_ITMO\\ITMO_2017\\Storage\\wp.txt"));


        // создаём аррайлист потоков, длина аррайлиста соответсвует количеству процессоров
        List<Thread> listThread = new ArrayList<>(numProcessors);

        Producer producer = new Producer(words,listThread);
        producer.startQueue();

        System.out.println(num);

    }


    public static class Producer{

        ArrayList<String> stringArrayList;
        static BlockingQueue <String> blockingQueue;
        volatile static public Queue<Map<String, Integer>> resultQueue = new ConcurrentLinkedQueue<>();
        ArrayList<Thread> listThread;
        static Iterator<String> iteratorQueue;

        private final static String STOP = "-=STOP=-"; // стоп-сигнал для потоков берущих стринги из BlockingQueue

        public Producer(List<String> stringList, List<Thread> listThread){
            this.stringArrayList=new ArrayList<>(stringList);
            this.blockingQueue = new LinkedBlockingQueue<>();
            this.listThread = new ArrayList<>(listThread);
            iteratorQueue = stringArrayList.iterator();
        }

           public void startQueue(){

               while (iteratorQueue.hasNext()){
                blockingQueue.offer(iteratorQueue.next());
            }
               blockingQueue.add(STOP);


               System.out.println("Создана BlockingQueue, её размер: " +blockingQueue.size());
               System.out.println(blockingQueue);

               try {
                   startThreads(); //стартуем потоки
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               System.out.println(blockingQueue);
           }
           private void startThreads() throws InterruptedException {

               // создаём аррайлист размером равны количеству ядер процессора
               int numCPU =Runtime.getRuntime().availableProcessors();
               List<Thread> listThread = new ArrayList<>(numCPU);

               // добавляем в аррайлист потоки
               for (int i =0;i<numCPU;i++){
                   listThread.add(new ThreadBook("Consumer#"+(i+1)));
               }

               // стартуем потоки
               for(Thread thread:listThread){
                 thread.start();
               }

               for (Thread thread:listThread){
                   thread.join();
               }

               System.out.println(resultQueue.size());
           }

    }


     static class ThreadBook extends Thread{

        Map <String,Integer> map = new HashMap<>();

        public ThreadBook (String name){
            new Thread(this);
            setName(name);
        }


        @Override
        public void  run() {
                int cnt=0;
                Iterator<String> iteratorThread = Producer.blockingQueue.iterator();
                while (iteratorThread.hasNext() && !iteratorThread.next().equals(Producer.STOP)) {
                    String word = iteratorThread.next();
                        try {
                            if(!map.containsKey(word)){
                            map.put(Producer.blockingQueue.take(),1); increment();}
                            else{map.put(Producer.blockingQueue.take(),++cnt); increment();}
                           } catch (InterruptedException e) {
                            e.printStackTrace();
                           }
                }
                Producer.resultQueue.offer(map);
                System.out.printf("Поток %s создал мапу размером: %s\n",getName(),map.size());
           }
        }
    }