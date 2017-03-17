/*  Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
    первый и второй члены последовательности равны единицам, а каждый следующий — сумме
    двух предыдущих.
 */

package Task2.part_3;

public class Task_2_8 {
    public static void main(String[] args) {


        int f1 = 0;
        int f2 = 1;
        int x =1;
        System.out.println(x);
        for (int i = 0; i < 11;i++) {
            System.out.println(x);
            f1=f2;
            f2=x;
            x=f1+f2;

        }

    }
}
