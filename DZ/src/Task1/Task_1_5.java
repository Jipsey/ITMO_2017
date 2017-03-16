package Task1;

import java.util.Scanner;

public class Task_1_5 {

    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        Scanner num = new Scanner(System.in);
        int a = num.nextInt();
        int b = a % 2;

        System.out.print(b!=1);
        if (b!=1){
            System.out.println(" - Вы ввели чётное число");
        }
        else System.out.println(" - Вы ввели нечётное число");
    }
}
