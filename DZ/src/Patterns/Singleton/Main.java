package Patterns.Singleton;
import static Patterns.Singleton.Factory.Reg.*;

/**
 *
 */

public class Main {
    public static void main(String[] args) {

       Car car = Factory.getFactory(RU);
        System.out.println( car.drive(200));

    }
}
