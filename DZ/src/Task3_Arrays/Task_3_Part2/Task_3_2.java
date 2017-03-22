/**
 *  Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел
    из отрезка [-99;99]. Вывести массив на экран. После на отдельной строке вывести на экран
    значение максимального элемента этого массива (его индекс не имеет значения).
 */
package Task3_Arrays.Task_3_Part2;
import Task3_Arrays.mine;

public class Task_3_2 {
    public static void main(String[] args) {
        int [][] arr = new int[5][8];
        int x = 0;
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 8 ; j++) {
            arr[i][j] = mine.rand(-99,99);
            if (arr[i][j] > x ){x=arr[i][j];}
            System.out.print(arr[i][j]+"\t");
            }
            System.out.print("\n");
        }
        System.out.println(x + " наибольшее число из массива");


    }
}
