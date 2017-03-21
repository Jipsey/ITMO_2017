/* Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран
   сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один
   элемент от другого началом новой строки). Перед созданием массива подумайте, какого он
   будет размера.2 4 6 … 18 20246…20
 */

package Task3_Arrays;

import java.util.Arrays;

public class Task_3_1 {

        public static void main(String[] args)  {

            int[] arr =new int[10];
            int b=0;

            for (int i = 0; i <arr.length ; i++) {

                b = b+2;
                arr[i] = b;
            }

            System.out.println(Arrays.toString(arr));
            for (int n = 0; n < arr.length; n++) {

                System.out.println(arr[n]);
            }

    }
}
