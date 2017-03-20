/*   Создать программу, выводящую на экран ближайшее к 10 из двух чисел, записанных в
     переменные m и n. Например, среди чисел 8,5 и 11,45 ближайшее к десяти 11,45.
*/

package Task2_loops.part_1;

public class Task_2_2 {

    public static void main(String[] args) {
        double m= -1.5;
        double n = -6.5;

        if((10-m)>(10-n)){
        System.out.println(n + " Ближе к 10");}
        else System.out.println(m + " Ближе к 10");
    }
}
