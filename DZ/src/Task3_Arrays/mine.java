package Task3_Arrays;

/**
 * в данном классе созданы методы которые ниболее часто используются при решении задач
 */
public class mine {
    public static int rand ( int min, int max){   // метод для присвоения рандомных чисел
        max = max - min;
        return (int) (Math.random() * ++max) + min;
    }
}
