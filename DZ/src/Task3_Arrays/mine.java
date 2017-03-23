/**
 * в данном классе созданы методы которые ниболее часто используются при решении задач
 */

package Task3_Arrays;
import java.util.Arrays;

public class mine {
    public static int rand ( int min, int max){   // метод для создания случайных чисел из заданного диапазона
        max = max - min;
        return (int) (Math.random() * ++max) + min;}


    public static void printArr(int[] intArr) {
            System.out.println(Arrays.toString(intArr));
    }

}
