/**
 *   Создайте два массива из 10 целых случайных чисел из отрезка [1;9] и третий массив из 10
   действительных чисел. Каждый элемент с i-ым индексом третьего массива должен равняться
   отношению элемента из первого массива с i-ым индексом к элементу из второго массива с i-
   ым индексом. Вывести все три массива на экран (каждый на отдельной строке), затем
   вывести количество целых элементов в третьем массиве
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_9 {
    public static void main(String[] args)  {
        System.out.println();
        int x=0; //счётчик целых элементов третьего массива
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        double[] arr3 = new double[10];
        for (int i = 0; i < arr1.length ; i++) {
            arr1[i]=Task_3_8.rand(1,9); }
        for (int i = 0; i < arr1.length ; i++) {
            arr2[i]=Task_3_8.rand(1,9); }
        for (int i = 0; i < arr1.length ; i++) {
            arr3[i]= (double)arr1[i]/(double)arr2[i]; }
        System.out.println(Arrays.toString(arr1) +"\n" + Arrays.toString(arr2)+"\n"+Arrays.toString(arr3));
        for (int i = 0; i <arr3.length  ; i++) {
             if (arr3[i]%1 ==0 ){x++;} }
        System.out.println("Всего целых элементов третьего массива: " +x);
    }
}
