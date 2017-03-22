/**
 *   Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив на
     экран в строку. Определите какой элемент встречается в массиве чаще всего и выведите об
     этом сообщение на экран. Если два каких-то элемента встречаются одинаковое количество
     раз, то не выводите ничего.
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_10 {
    public static void main(String[] args) {

        int[] arr = new int[11];
        int a,b, c;
        a=b=c=0;

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = mine.rand(-1,1); }
        System.out.println(Arrays.toString(arr) + "  массив до сортировки");
            Arrays.sort(arr);

        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == -1) {a++;}
            else if(arr[i] == 0){b++;}
            else c++; }
        System.out.println(Arrays.toString(arr) + "  массив после сортировки");
        System.out.printf("%s %s %s\n",a,b,c);
        if ((a > b) && (a > c)) System.out.println("Элемент '-1' встречается чаще всего");
        if ((b > a) && (b > c)) System.out.println("Элемент '0' встречается чаще всего");
        if((c > a) && (c > b)) System.out.println("Элемент '1' встречается чаще всего");

    }

}
