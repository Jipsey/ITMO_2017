package Stepik;


import java.util.function.DoubleUnaryOperator;

public class Task_357 {
    public static void main(String[] args) {

        System.out.println( integrate(x -> 1,0,10));

    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {

        double result = 0, grid = 0, currentA  = a, currentB = b, currentDelta = 0, delta = 1E-100;
        int stepsNumber;

        if (a >= b) {
            System.exit(-1);
        }

        do {
            currentB = currentA + (currentB - currentA) * 0.5;
            grid = currentB - currentA;
            currentDelta = f.applyAsDouble(currentA) - f.applyAsDouble(currentB);
        } while (currentDelta > delta);

        System.out.println("delta = " + ((Double)delta).toString());
        System.out.println("grid = " + ((Double)grid).toString());

        stepsNumber = (int)((b - a) / grid); //without a right border

        for (int i = 0; i < stepsNumber; i++) {
            result += f.applyAsDouble(a + grid * i);
        }

        return result *= grid;
    }


}

