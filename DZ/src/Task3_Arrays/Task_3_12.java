/**
     Программа должна создать массив из 12 случайных целых чисел из отрезка [-10;10]
     таким образом, чтобы отрицательных и положительных элементов там было поровну и не
     было нулей. При этом порядок следования элементов должен быть случаен (т. е. не подходит
     вариант, когда в массиве постоянно выпадает сначала 6 положительных, а потом 6
     отрицательных чисел или же когда элементы постоянно чередуются через один и пр.).
     Вывести полученный массив на экран.
 */
package Task3_Arrays;

import java.util.Arrays;

public class Task_3_12 {
    public static void main(String[] args) {

        int[] arr = new int[12];
        int a = 0;
        int posN = 0;
        int negN = 0;

        for (int i = 0; i < arr.length ; i++) {

            while((a >= -10) && (a <= 10)){
                if(negN==(arr.length)/2){a=mine.rand(0,10);}
                if(posN==(arr.length)/2){a=mine.rand(-10,0);}
                else if(negN !=(arr.length/2) && posN !=(arr.length/2)){a = mine.rand(-10,10);}
            if(a>=-10 && a <= 10 && a!=0 )break;}
            if (a<0) {negN++;}
            else {posN++;}
            arr [i] = a;}

        System.out.printf("%s\n%s\n",posN+" положительных чисел ",negN + " отрицательных чисел ");

        System.out.println(Arrays.toString(arr));
    }
}
