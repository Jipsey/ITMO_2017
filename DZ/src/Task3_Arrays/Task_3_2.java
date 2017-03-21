/*
   Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
   этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
   1).
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_2 {

    public static void main(String[] args)  {
        int[] arr = new int [50];
        int b=1;
        for (int i = 0; i <arr.length ; i++) {

            arr [i] = b;
            b=b+2;
        }
        System.out.println(Arrays.toString(arr));
        for (int n = 1; n <arr.length ; n++) {

            System.out.print(arr[arr.length-n]+"\t");

        }

    }
}
