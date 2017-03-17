/* Создать программу, проверяющую и сообщающую на экран, является ли целое число
         записанное в переменную n, чётным либо нечётным.
*/

package Task2.part_1;

public class Task_2_1 {


    public static void main(String[] args) {

        int i = 2;
         if ((i%2)!=0){
             System.out.println("Вы ввели нечетное число");
         }
         else System.out.println("Вы ввели четное число");

    }
}