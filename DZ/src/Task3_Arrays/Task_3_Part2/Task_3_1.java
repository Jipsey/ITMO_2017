/**
 * Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел
   из отрезка [10;99]. Вывести массив на экран.
 */
package Task3_Arrays.Task_3_Part2;

import Task3_Arrays.mine;

import java.util.Arrays;

public class Task_3_1 {
    public static void main(String[] args) {
        int[][] arr= new int[8][5];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5 ; j++) {
                arr[i][j] = mine.rand(10,99);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("Строка №" +(i+1) + "\n");
        }
        }

    }
