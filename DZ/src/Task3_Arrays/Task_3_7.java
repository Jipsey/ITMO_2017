/**
 * Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
   что первый и второй члены последовательности равны единицам, а каждый следующий —
   сумме двух предыдущих.
 */

package Task3_Arrays;

import java.util.Arrays;

public class Task_3_7 {
    public static void main(String[] args)  {
        int[] arr = new int[20];

        int x;
        int f1=0;
        int f2=1;

        for (int i = 0; i <20 ; i++) {

        x = f1 + f2;
        f2=f1;
        f1=x;
        arr[i] = x;
        System.out.print(x +"\t"); }
        System.out.print("\n"+Arrays.toString(arr));

        System.out.println();
    }
}
