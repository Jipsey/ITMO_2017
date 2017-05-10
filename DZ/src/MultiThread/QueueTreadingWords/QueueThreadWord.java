package MultiThread.QueueTreadingWords;

import MultiThread.ThreadWordPeace;
import javafx.scene.Parent;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static Task_Collections_Map.WordPeace.readWords;
import static Task_Collections_Map.WordPeace.topForMap;


public class QueueThreadWord {

    private static Map<String, Integer> sharedMap = new HashMap<>();


    public static void main(String[] args) throws Exception {


        int numProcessors = Runtime.getRuntime().availableProcessors();
        System.out.printf("У нас %s ядра процесссора!\n", numProcessors);

        // создаём список из слов из книги
        List<String> words = readWords(new File("D:\\Other\\FOR_DEVELOPER\\Курсы ИТМО\\Projects\\Education_ITMO\\ITMO_2017\\Storage\\wp.txt"));


        // создаём аррайлист потоков, длина аррайлиста соответсвует количеству процессоров
        List<Thread> listThread = new ArrayList<>(numProcessors);

        Producer producer = new Producer(words, listThread);
        producer.startQueue();
        topForMap(sharedMap, 10);
        System.out.println("Общая мапа, размер: " + sharedMap.size());
    }

    private Map<String, Integer> assembleMap(Queue<Map<String, Integer>> incomingQueueMap) {

        while (!incomingQueueMap.isEmpty()) {
            Map<String, Integer> mapTemp = incomingQueueMap.poll();
            if (sharedMap == null) {
                for (String str : mapTemp.keySet()) {
                    sharedMap.putIfAbsent(str, str.indexOf(str));
                }
            }
            for (String str : mapTemp.keySet()) {
                sharedMap.compute(str, (key, value) -> (value == null) ? mapTemp.get(key) : value + mapTemp.get(key));
            }
        }
        return sharedMap;
    }


    public static class Producer {

        ArrayList<String> stringArrayList;
        volatile static BlockingQueue<String> blockingQueue;
        volatile static public Queue<Map<String, Integer>> resultQueue = new ConcurrentLinkedQueue<>();
        ArrayList<Thread> listThread;
        static Iterator<String> iteratorQueue;

        private final static String STOP = new String("-=STOP=-"); // стоп-сигнал для потоков берущих стринги из BlockingQueue

        public Producer(List<String> stringList, List<Thread> listThread) {
            this.stringArrayList = new ArrayList<>(stringList);
            this.blockingQueue = new LinkedBlockingQueue<>();
            this.listThread = new ArrayList<>(listThread);
            iteratorQueue = stringArrayList.iterator();
        }

        public void startQueue() {

            while (iteratorQueue.hasNext()) {
                blockingQueue.offer(iteratorQueue.next());
            }
            blockingQueue.add(STOP);

            System.out.println("Создана BlockingQueue, её размер: " + blockingQueue.size() + " (+ слово-стоппер)");

            try {
                startThreads(); //стартуем потоки
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            QueueThreadWord qtw = new QueueThreadWord();
            qtw.assembleMap(Producer.resultQueue);

            System.out.printf("Очередь после обработки потоками :\n%s\n", blockingQueue);

        }


        private void startThreads() throws InterruptedException {

            // создаём аррайлист размером равны количеству ядер процессора
            int numCPU = Runtime.getRuntime().availableProcessors();
            List<Thread> listThread = new ArrayList<>(numCPU);

            // добавляем в аррайлист потоки
            for (int i = 0; i < numCPU; i++) {
                listThread.add(new ThreadBook("Consumer#" + (i + 1)));
            }

            // стартуем потоки
            for (Thread thread : listThread) {
                thread.start();
            }

            for (Thread thread : listThread) {
                thread.join();
            }

            System.out.println(resultQueue.size());
            System.out.println(resultQueue);
        }


    }


    static class ThreadBook extends Thread {

        Map<String, Integer> map = new HashMap<>();

        public ThreadBook(String name) {
            new Thread(this);
            setName(name);
        }


        @Override
        public void run() {

            try {
                String word;
                while ((word = Producer.blockingQueue.take()) != Producer.STOP) {
                    Integer c = map.get(word);

                    map.put(word, c == null ? 1 : c + 1);

                    //Thread.sleep(1);
                }
                Producer.blockingQueue.add(Producer.STOP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Producer.resultQueue.add(map);


            System.out.printf("Поток %s создал мапу размером: %s\n", getName(), map.size());
        }
    }
}