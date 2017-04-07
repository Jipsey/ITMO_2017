package Task6_Objects.List_new;

import java.util.Objects;

/**Сделать утилитарный класс (Utils) со статическими методами:
 a) Object Utils.find(Predicate pred, List list), где Predicate - интерфейс с единственным методом
 boolean apply(Object obj). Метод итерируется по всем элементам списка (используйте for(:) конструкцию)
 и возвращает первый элемент, удовлетворяющий условию (т.е. pred.apply(obj) == true).
 *
 */
public class ListMain {

    public static void main(String[] args) {

        List list = new MyLinkedList();


        for (int i = 0; i <10 ; i++) {
            list.add(i);
        }


        for (int i=0; i<10;i++) {

            System.out.println(list.get(i));

        }

        list.remove(5);


        for (int i=0; i<10;i++) {

            System.out.println(list.get(i));

        }


    }
}
