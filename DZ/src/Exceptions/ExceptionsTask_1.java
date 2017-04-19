package Exceptions;

import Task6_Objects.List_new.*;

/**
 *  Написать свои исключения для LinkedList и ArrayList
   - если берётся (get()) элемент которого нет;
   - метод Итератора next() должен выбрасывать исключения типа
   ConcurrentModificationException если коллекция изменяется во время итерирования;
   - добавить метод size();
 */

public class ExceptionsTask_1 {

    public static void main(String[] args ) throws Exception {

        List list = new MyLinkedList();

        for(int i=0; i<3;i++){
            list.add(i);

        }

        System.out.println(list.size());

         for(int i=0;i<2;i++){
             System.out.println(list.get(0));
         }

        }
    }

