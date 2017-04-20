package Patterns;
import static Patterns.Factory.Reg.*;

/**
 *
 */

public class Main {
    public static void main(String[] args) {

       Car car = Factory.getFactory(JP);
       car.drive(200);

    }
}
