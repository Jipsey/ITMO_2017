/**
 *  Создать двумерный массив из 6 строк по 7 столбцов в каждой из случайных целых чисел
    из отрезка [0;9]. Вывести массив на экран. Преобразовать массив таким образом, чтобы на
    первом месте в каждой строке стоял её наибольший элемент. При этом изменять состав
    массива нельзя, а можно только переставлять элементы в рамках одной строки. Порядок
    остальных элементов строки не важен (т.е. можно соврешить только одну перестановку, а
    можно отсортировать по убыванию каждую строку). Вывести преобразованный массив на
    экран.
 */
package Task3_Arrays.Task_3_Part2;

import Task3_Arrays.mine;

public class Task_3_4 {

    public static void main(String[] args) {
        int [][] arr = new int [7][6];
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                arr[j][i]=mine.rand(0,9);
                System.out.print(arr[j][i]+"\t");
            }   System.out.print("\n");}

        for (int i = 0; i <6 ; i++) {
            while((arr[0][i] < arr[1][i]) || (arr[1][i] < arr[2][i]) || (arr[2][i] < arr[3][i]) ||
                    arr[3][i] < arr[4][i] || arr[4][i] < arr[5][i]) {

                 for (int j = 0; j <arr.length-1 ; j++) {
                 //if(j == 6){j=1;}
                 if(arr[j][i] < arr[j+1][i]){int q = arr[j][i];arr[j][i] = arr[j+1][i];arr[j+1][i]=q;}
                     }
            }
        }

        System.out.println("************************\n"+" Массив после сортировки ");
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(arr[j][i]+"\t");}
                System.out.print("\n");
        }

    }
}
