package Task2.part_3;

import java.util.Scanner;

public class Task_2_9 {

    public static void main(String[] args) {
        System.out.print("введите любое целое число: ");
        Scanner num  = new Scanner(System.in);
        int a = num.nextInt();
        String c = Integer.toString(a);
        int b = c.length();
        int n = 0 ;
        int x = 0;

        for (int i = 0; i < b ; i++) {
            String d = c.substring(n,n+1);
            n++;
            int y = Integer.parseInt(d);
            int sum = x + y;
            x=sum;
            if (i==b-1){
            System.out.println(sum + " - сумма чисел");}
        }

        System.out.println(b + " - количество цифр в числе");
    }

}
