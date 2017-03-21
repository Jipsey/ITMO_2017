/**
 *  Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
 *  строку. Определить и вывести на экран сообщение о том, является ли массив строго
 *  возрастающей последовательностью.
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_6 {
    public static void main(String[] args)  {
        int[] arr = new int[4];

        for (int i = 0; i < arr.length; i++) {

            arr[i]=(int)((Math.random()*89)+10);
        }
        System.out.println(Arrays.toString(arr));
        if(arr[0]>arr[1]&& arr[1]>arr[2] && arr[2]>arr[3]) {
            System.out.println("Массив строго возрастающий! ");
        }
    }
}
