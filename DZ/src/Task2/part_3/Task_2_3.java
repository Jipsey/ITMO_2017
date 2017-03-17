/* Создайте программу, выводящую на экран все неотрицательные элементы
   последовательности 90 85 80 75 70 65 60 ….
*/
package Task2.part_3;

public class Task_2_3 {
    public static void main(String[] args) {

        for (int i = 90; i >0 ; i=(i-5)) {
            System.out.println(i);
        }

    }
}
