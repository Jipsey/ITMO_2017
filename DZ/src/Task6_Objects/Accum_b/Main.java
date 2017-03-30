package Task6_Objects.Accum_b;

import java.util.Arrays;

/**
 *
 */
public class Main {
    public static void main(String[] args) {

        double[] arr = new double[4];     // заполняем первый массив arr значением 0
        for(int i=0; i<arr.length; i++){  //
            arr [i] =0;
        }
        Operation[] arrOp = {new Operation() {
            @Override
            public double apply(double a, double b) {
                return a + b;
            }
        }, (a, b) ->a-b ,(a, b)->a*b,(a, b)->a/b}; // заполняем второй массив
                                                                                  // анонимными классами, реализуя
                                                                                  // интерфейс Operation

        Accumulator acc = new Accumulator(arr,arrOp );

        acc.calculate(1.0);
        System.out.println(Arrays.toString(acc.getValue()));

        acc.calculate(5.0);
        System.out.println(Arrays.toString(acc.getValue()));

        acc.calculate(3.0);
        System.out.println(Arrays.toString(acc.getValue()));
    }
}
