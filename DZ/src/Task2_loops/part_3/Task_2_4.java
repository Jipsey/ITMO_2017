/*  Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
    16 32 64 128 ….
 */
package Task2_loops.part_3;

public class Task_2_4 {
    public static void main(String[] args) {
         int m=2;
        for (int i = 0; i < 20 ; i++) {
          m=m*2;
        System.out.println(m);
        }
        }
}
