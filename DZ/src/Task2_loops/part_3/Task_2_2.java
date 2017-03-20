/*   Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5
     7 9 11 13 15 17 ….
 */

package Task2_loops.part_3;


public class Task_2_2 {
    public static void main(String[] args) {
        int m=1;
        for (int i = 0; i <55 ; i++) {
            m+=2;

            System.out.println(m);
        }

    }
}
