/**
 *  Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
 *  массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
 *  каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
 *  сообщите, что их средние арифметические равны).
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_5 {
    public static void main(String[] args) {

        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int x =0;
        int y=0;
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i <arr1.length ; i++){
            arr1[i]=(int)(Math.random()*5);

            int num1=x + arr1[i];
            x=num1;
        }

        for (int n = 0; n < arr2.length ; n++){
            arr2[n]=(int)(Math.random()*5);}

        for (int i = 0; i< arr2.length ; i++) {

         int num2= y + arr2[i];
           y =num2;}


        for (int num1:arr1){sum1 = sum1 + num1;}
        double mid1=sum1/arr1.length;

        for (int num2:arr2){sum2=sum2+num2;}
        double mid2=sum2/arr2.length;

        System.out.println(Arrays.toString(arr1)+ mid1 +"\n" +
                Arrays.toString(arr2) + mid2 + "\n");
        if(mid1 > mid2){ System.out.println("Среднее арифмитическое первого массива больше чем второго");}
        else if (mid1 < mid2){System.out.println("Среднее арифмитическое второго массива больше чем первого");}
            else{System.out.println("Они равны");}
        }
    }

