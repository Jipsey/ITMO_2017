package MultiThread;

import java.io.File;
import java.util.*;

import static Task_Collections_Map.WordPeace.readWords;
import static Task_Collections_Map.WordPeace.top;


public class ThreadWordPeace {
        private int num = 0;           // счётчик слов в книге
        private Map<String,Integer> sharedMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        ThreadWordPeace twp = new ThreadWordPeace();

        int numProcessors =Runtime.getRuntime().availableProcessors();
        System.out.printf("У нас %s ядра процесссора!\n",numProcessors);

        // создаём список из слов из книги
        List<String> words = readWords(new File("C:\\Education_ITMO\\ITMO_2017\\Storage\\wp.txt"));

        // создаём аррайлист потоков, длина аррайлиста соответсвует количеству процессоров
        List<Thread> listThread = new ArrayList<>(numProcessors);


        // теперь в каждый элемент массива добавляем по потоку
        for (int i =0;i<numProcessors;i++){
            listThread.add(twp.new ThreadBook(words,"#"+(i+1),numProcessors,numProcessors-i));
        }

        // стартуем каждый
        for (Thread thread:listThread){thread.start();}

        // прерываем каждый
         for (Thread thread:listThread) { thread.join(); }

        System.out.println("Всего операций с мапой: "+twp.num);
        System.out.println(twp.sharedMap.size());
    }

    private synchronized void increment(){
        num++;
    }

    private synchronized void conMap (Map<String,Integer> incomingMap){
        if (sharedMap==null){ for(String str:incomingMap.keySet()){
            sharedMap.putIfAbsent(str,str.indexOf(str));}}
        else {
            for(String str :incomingMap.keySet()){
            sharedMap.compute(str,(key,value)->(value==null)?1:value+incomingMap.get(key));}
        }
    }

    class ThreadBook extends Thread{
        Map <String,Integer> map = new HashMap<>();
        private List<String> words; // лист слов, инициализируется через конструктор


        public ThreadBook(List<String> words, String name, int parts, int readPartNumber){
            setName(name);
            separator(words,parts,readPartNumber);
        }

    private void separator (List<String> words,int parts, int readPartNumber){
            Double wordX = (double)words.size()*((double) readPartNumber/(double) parts);
            Double x = wordX-(words.size()/4);
            if(readPartNumber==1){x = x +1;}
            this.words=new ArrayList<>(words.subList(x.intValue()-1,wordX.intValue()));
        }


        @Override
        public void  run() {

                    for (int i=0; i < words.size(); i++) {
                        String word = words.get(i);
                        if (!map.containsKey(word)) {
                            map.put(word,1); increment();
                        }
                        else { Integer cnt = map.get(word);
                               map.put(word,++cnt); increment();}

            }
            conMap(map);
            System.out.printf("Поток %s создал мапу размером: %s\n",getName(),map.size());
          }
        }
    }
