/** Cоздать двумерный массив из 7 строк по 4 столбца в каждой из случайных целых чисел из
    отрезка [-5;5]. Вывести массив на экран. Определить и вывести на экран индекс строки с
    наибольшим по модулю произведением элементов. Если таких строк несколько, то вывести
    индекс первой встретившейся из них.
 */

package Task3_Arrays.Task_3_Part2;

import Task3_Arrays.mine;

public class Task_3_3 {
    public static void main(String[] args) {
        int[][] arr = new int[4][7];
        int  x;
        int  y =0;
        int  maxE =0;
        int  q=0; // переменные для определения строки с максимальной суммой элементов
        int numStr = 0;
        for (int i = 0; i <7 ; i++) {
            for (int j = 0; j <4; j++) {
                arr[j][i] = mine.rand(-5,5);
                x = Math.abs(arr[j][i]);
                maxE = x + y;
                y = maxE;
                System.out.print(arr[j][i]+"\t");}
              if(maxE > q){numStr = i ;
                q=maxE;}

            System.out.print(" " + maxE + "\tстрока под индексом "+ i + "\n");
            maxE = 0; y=0 ;
        }
        System.out.println("индекс строки с нибольшей суммой элементов по модулю " + numStr);
    }
}
