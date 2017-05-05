package MyUtils;

public class RandmomMy {

    public static int random ( int min, int max){   // метод для создания случайных чисел из заданного диапазона
        max = max - min;
        return (int) (Math.random() * ++max) + min;}

}
