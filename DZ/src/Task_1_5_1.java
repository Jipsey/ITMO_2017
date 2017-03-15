/*
программа определяющая чётное число ввел
пользователь или нечётное, зная что все чётные числа
в двоичной системе исчисления оканчиваются на 0.
 */

import java.util.Scanner;

public class Task_1_5_1 {

    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        Scanner num = new Scanner(System.in);
        int a = num.nextInt();
        String b = Integer.toBinaryString(a);
        String f = b.substring(b.length()-1);
        int m = Integer.parseInt(f);

        System.out.println(b + " - Бинарный код веденного числа");
        System.out.println(m + " - Последняя цифра бинарного кода");
        if (m != 1){
            System.out.print("Вы ввели чётное число");
        }
        else System.out.print("Вы ввели нечётное число");

    }
}
