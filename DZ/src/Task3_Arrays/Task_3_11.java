
/**  Пользователь должен указать с клавиатуры чётное положительное число, а программа
     должна создать массив указанного размера из случайных целых чисел из [-5;5] и вывести его
     на экран в строку. После этого программа должна определить и сообщить пользователю о
     том, сумма модулей какой половины массива больше: левой или правой, либо сообщить, что
     эти суммы модулей равны. Если пользователь введёт неподходящее число, то программа
     должна требовать повторного ввода до тех пор, пока не будет указано корректное значение.
 */
package Task3_Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class Task_3_11 {

    public static void main(String[] args) {
        int a=0;
        while (a<=0 || a%2!=0){
        System.out.print("Введите чётное, положительное число: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        if ( a%2!=0 || a<=0) continue;}
        int[] arr = new int[a];
        int sum1,sum2,x,y;
        sum1=sum2=x=y=0;

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = mine.rand(-5,5);}

        for (int i = 0; i <arr.length; i++) {
            if (i>=arr.length/2){
                sum2 = y + Math.abs(arr[i]);
                y= sum2;}
            if(i<arr.length/2) { sum1 = x + Math.abs(arr[i]);
                x= sum1; }}

        System.out.println(Arrays.toString(arr));
        System.out.println(sum1);
        System.out.println(sum2);

        if (sum1>sum2) System.out.println("Сумма модулей элементов левой половины массива " +
                "больше суммы элементов правой половины  ");
        if (sum2>sum1) System.out.println("Сумма модулей элементов правой половины массива " +
                "больше суммы элементов левой половины ");
        else if(sum1==sum2){System.out.println("Сумма модулей правой половины равна сумме модулей левой половины");}
    }
}
