package MultiThread;

import java.io.File;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static Task_Collections_Map.WordPeace.*;


public class ThreadWordPeace {
    protected int num = 0;           // счётчик слов в книге
    private volatile Map<String, Integer> sharedMap = new HashMap<>();

    public Map<String, Integer> getSharedMap() {
        return sharedMap;
    }

    public static void main(String[] args) throws Exception {

        ThreadWordPeace twp = new ThreadWordPeace();

        int numProcessors = Runtime.getRuntime().availableProcessors();
        System.out.printf("У нас %s ядра процесссора!\n", numProcessors);

        // создаём список из слов из книги
        List<String> words = readWords(new File("C:\\Education_ITMO\\ITMO_2017\\Storage\\wp.txt"));


        // создаём аррайлист потоков, длина аррайлиста соответсвует количеству процессоров
        List<Thread> listThread = new ArrayList<>(numProcessors);


        // теперь в каждый элемент массива добавляем по потоку
        for (int i = 0; i < numProcessors; i++) {
            listThread.add(new Thread(twp.
                    new ThreadBook(words, "#" + (i + 1), numProcessors, numProcessors - i)));
        }

        // стартуем каждый
        for (Thread thread : listThread) {
            thread.start();
        }

        // прерываем каждый
        for (Thread thread : listThread) {
            thread.join();
        }

        System.out.println("Всего операций с мапой: " + twp.num);

        System.out.printf("Размер общей мапы: %s слов(а)\n", twp.sharedMap.size());
        topForMap(twp.sharedMap, 10);


    }

    private void increment() {
        num++;
    }

    private synchronized Map<String, Integer> makeMap(List<String> words, Map<String, Integer> map) {

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!map.containsKey(word)) {
                map.put(word, 1);
                increment();
            } else {
                Integer cnt = map.get(word);
                map.put(word, ++cnt);
                increment();
            }
        }
        return map;
    }

    protected synchronized Map<String, Integer> assembleMap(Map<String, Integer> incomingMap) {
        if (sharedMap == null) {
            for (String str : incomingMap.keySet()) {
                sharedMap.putIfAbsent(str, str.indexOf(str));
            }
        } else {
            for (String str : incomingMap.keySet()) {
                sharedMap.compute(str, (key, value) -> (value == null) ? incomingMap.get(key) : value + incomingMap.get(key));
            }
        }
        return sharedMap;
    }

    // перегруженный метод для класса ThreadPool
    protected Map<String, Integer> assembleMap(Map<String, Integer> baseMap, Map<String, Integer> incomingMap) {
        if (baseMap == null) {
            for (String str : incomingMap.keySet()) {
                baseMap.putIfAbsent(str, str.indexOf(str));
            }
        } else {
            for (String str : incomingMap.keySet()) {
                baseMap.compute(str, (key, value) -> (value == null) ? incomingMap.get(key) : value + incomingMap.get(key));
            }
        }
        return baseMap;
    }


    class ThreadBook implements Runnable {
        Map<String, Integer> map = new HashMap<>();
        private List<String> words; // лист слов, инициализируется через конструктор

        public Map<String, Integer> getMap() {
            return map;
        }

        public ThreadBook(List<String> words, String name, int parts, int readPartNumber) {

            new Thread(this, name);
            separator(words, parts, readPartNumber);
        }

        // конструктор для Task
        public ThreadBook(List<String> words, int parts, int readPartNumber) {
            new Thread(this);
            separator(words, parts, readPartNumber);

        }

        private void separator(List<String> words, int parts, int readPartNumber) {
            Double wordX = (double) words.size() * ((double) readPartNumber / (double) parts);
            Double x = wordX - (words.size() / parts);
            if (readPartNumber == 1) {
                x = x + 1;
            }
            this.words = new ArrayList<>(words.subList(x.intValue() - 1, wordX.intValue()));
        }

        @Override
        public void run() {

            assembleMap(makeMap(words, map));

            System.out.printf("Поток %s создал мапу размером: %s\n", Thread.currentThread().getName(), map.size());
        }

    }
}