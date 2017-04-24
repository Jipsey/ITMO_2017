package Task_Collections_Map;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class WordPeace {
    public static void main(String[] args) throws IOException {

        List<String> s = readWords(new File("C:\\Education_ITMO\\ITMO_2017\\Storage\\wp.txt"));

        top(s,10);
    }

        static List<String> readWords(File file) throws IOException {

        List <String> lines = Files.readAllLines(file.toPath());
        ArrayList <String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit =line.toLowerCase().replaceAll("\\p{Punct}", " ").trim().split("\\s");

            for (String s : wordSplit) {
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }
            System.out.println("Всего слов в книге: " + words.size());
              return words;

        }

     public static void top(List<String> list,int top){

         Map <String,Integer> mapWord = new HashMap<>();

         for (String word: list){
             // алгоритм следующий, если в мапе не содержится входящее слова, что проверяется методом .containsKey()
             // то добавляем в мапу входящее слово со значением 1(то есть считаем, что в книге данных слов,
             // на данный момент, // только 1шт)
             if (!mapWord.containsKey(word)) {
                 mapWord.put(word,1);
             }
             // если же входящее слово уже содержится в мапе, то счетчик слов записываем во временное поле cnt,
             // заме инкрементируем счетчик(cnt++), и уже инкрементированный счетчки заночим в мапу
             else { Integer cnt = mapWord.get(word); cnt++;
                 mapWord.put(word,cnt);
             }

         }

          //т.к. MAP нельзя отсортировать по значения, создаём АррайЛист и заносим туда ключи+значения,
         // после чего сорируем уже АррайЛист

         List<Map.Entry<String,Integer>> arrL = new ArrayList<>(mapWord.entrySet());

         arrL.sort(new Comparator<Map.Entry<String, Integer>>() {
             @Override
             public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                 return Integer.compare(o1.getValue(), o2.getValue());
             }
         });

         System.out.println("---------- Топ 10 слов из книги -----------");

         //выводим на консоль топ слов указаных в методе, в данном случае топ 10
         int n=1;

         for(int i = arrL.size(); i > (arrL.size() - top);i--){
         System.out.println("№" + (n++)+"\t" + arrL.get(i-1));
         }

         System.out.println("количество уникальных слов в книге: " + mapWord.size());
         // выводим на печать требуемое количество топовых слов

         // теперь группируем слова по длине

         Map <Integer,HashSet<String>> wordsSize = new HashMap <>();
          // заносим в новую map слова по ключу Integer (длина слова), значением будет HashSet, где элементом будет
          // само слово
         for (String word: list ) {
                 if (word.length() > 3) { // устанавливаем ограничение длины слова более трёх знаков
                     HashSet<String> hs = wordsSize.get(word.length());

                     if (hs == null)
                         hs = new HashSet<>();
                     hs.add(word);
                     wordsSize.put(word.length(), hs);
                 }
         }

         System.out.println(wordsSize);

     } }