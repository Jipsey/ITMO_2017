package MultiThread;

import java.io.File;
import java.util.*;

import static Task_Collections_Map.WordPeace.*;


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

        System.out.printf("Размер общей мапы: %s слов(а)\n",twp.sharedMap.size());
        topForMap(twp.sharedMap,10);

//        System.out.println(twp.sharedMap.get("the"));

    }

    private synchronized void increment(){
        num++;
    }

    private synchronized Map<String,Integer> makeMap (List<String> words, Map <String,Integer> map){

        for (int i=0; i < words.size(); i++) {
            String word = words.get(i);
            if (!map.containsKey(word)) {
                map.put(word,1); increment();
            }
            else { Integer cnt = map.get(word);
                map.put(word,++cnt); increment();}
        }
        //System.out.printf("Поток добавил в мапу key the': %s\n",map.get("the"));
        return map;
    }

    private synchronized Map<String,Integer> assembleMap (Map<String,Integer> incomingMap){
        if (sharedMap==null){ for(String str:incomingMap.keySet()){
            sharedMap.putIfAbsent(str,str.indexOf(str));}}
        else {
            for(String str :incomingMap.keySet()){
            sharedMap.compute(str,(key,value)->(value==null)?1:value+incomingMap.get(key));}
        } return sharedMap;
    }

    class ThreadBook extends Thread{
        Map <String,Integer> map = new HashMap<>();
        private List<String> words; // лист слов, инициализируется через конструктор


        public ThreadBook(List<String> words, String name, int parts, int readPartNumber){
            new Thread(this);
            setName(name);
            separator(words,parts,readPartNumber);
        }

    private synchronized void separator (List<String> words,int parts, int readPartNumber){
            Double wordX = (double)words.size()*((double) readPartNumber/(double) parts);
            Double x = wordX-(words.size()/parts);
            if(readPartNumber==1){x = x +1;}
            this.words=new ArrayList<>(words.subList(x.intValue()-1,wordX.intValue()));
        }


        @Override
        public synchronized void  run() {
           assembleMap(makeMap(words,map));

            System.out.printf("Поток %s создал мапу размером: %s\n",getName(),map.size());

         }
        }
    }
