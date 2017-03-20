
/*
   Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
   в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
   экран на отдельной строке
 */

package Task3_Arrays;

import java.util.Arrays;

public class Task_3_4 {
    public static void main(String[] args) {

        int [] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {

        int a = (int)((Math.random()*10) + 1);
        arr [i]=a;
        }
        System.out.println(Arrays.toString(arr));
        for (int n = 1; n <arr.length ; n++) {

            arr[n]=0;
            n++;}

        System.out.println(Arrays.toString(arr));
    }
}
