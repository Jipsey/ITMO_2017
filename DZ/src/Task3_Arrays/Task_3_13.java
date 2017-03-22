/**
 *  Пользователь вводит с клавиатуры натуральное число большее 3, которое сохраняется в
    переменную n. Если пользователь ввёл не подходящее число, то программа должна просить
    пользователя повторить ввод. Создать массив из n случайных целых чисел из отрезка [0;n] и
    вывести его на экран. Создать второй массив только из чётных элементов первого массива,
    если они там есть, и вывести его на экран.
 */

package Task3_Arrays;

import java.util.Arrays;
import java.util.Scanner;
import static Task3_Arrays.mine.*;

public class Task_3_13 {
    public static void main(String[] args) {
        int n=0;
        int m=0;// счетчик положительных элементов созданного массива
        int j=0;
        while (n <=3 ){
        System.out.print("Введите целое число больше 3: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();}

        int[] arr = new int[n];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = rand(0,n);
            if (arr[i]%2==0 && arr[i]!=0){m++;}}

            int[] arr2 = new int[m];

        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]%2==0 && arr[i]!=0){ arr2[j]=arr[i];j++; }}

            printArr(arr);
            printArr(arr2 );
        System.out.println(m +" Четных элемента(-ов) в первом массиве");
    }
}
