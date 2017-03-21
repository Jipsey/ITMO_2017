/*
 * Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
 * Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
 * отдельной строке.
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_3 {

    public static void main(String[] args) {

        int[] arr = new int[15];
        int x=0;
        for (int i = 0; i <arr.length ; i++)  {

        int a = (int)(Math.random()*9.9);
        arr[i]= a ;
    }
        for (int n = 0; n <arr.length ; n++)
         { if (arr[n]%2==0){x++;}}
        System.out.println(Arrays.toString(arr) );
        System.out.println("чётных чисел в массиве - "+x);
    }
}
