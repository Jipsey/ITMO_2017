/**  Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
     элемент является в этом массиве максимальным и сообщите индекс его последнего
     вхождения в массив.
 *
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_8 {
    public static void main(String[] args)  {

        int[] arr = new int[12];

        for (int i = 0; i <arr.length ; i++) {
            arr [i] = rand(-15,15);}

        int maxNum = arr[0], index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= maxNum) {
                maxNum = arr[i];
                index = i;}}
                System.out.println(Arrays.toString(arr));
                System.out.println("наибольший элемент массива  " + maxNum);
                System.out.println("номер индекса в массиве  " + index);}

        public static int rand ( int min, int max){
            max = max - min;
            return (int) (Math.random() * ++max) + min;
        }
    }
