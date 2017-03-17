/*  Выведите на экран все положительные делители натурального числа, введённого
    пользователем с клавиатуры.
 */

package Task2.part_3;

import java.util.Scanner;

public class Task_2_6 {

    public static void main(String[] args) {
        System.out.print("Введите целое число: ");

        Scanner num = new Scanner(System.in);
        int a = num.nextInt();
            a = Math.abs(a);


        if ((a%2)==0){
            System.out.println("Делители введеного числа:  " );
            int i=0;
            while(i<a){
                i++;
               int d = a/i;

                if((a%i)!=0)
                    continue;

                System.out.println(i);}


        }else System.out.println("Делители введненного числа 1 и " + a);


    }
}
