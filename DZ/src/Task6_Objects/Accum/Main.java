package Task6_Objects.Accum;

/**
 *
 */
public class Main {
    public static void main(String[] args) {

       Power pow = new Power();
       SquareRoot sr = new SquareRoot();
       Multiply mult = new Multiply();

        Accumulator acc1 = new Accumulator(5, new Operation() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        });

        Accumulator acc2 = new Accumulator(5, new Operation() {
            @Override
            public int apply(int a, int b) {
                return a % b;
            }
        });

        Accumulator acc3 = new Accumulator(5, new Operation() {
            @Override
            public int apply(int a, int b) {
                return a / b;
            }
        });

        acc1.calculate(3);
        acc2.calculate(6);
        acc3.calculate(5);
        System.out.printf("%s\t %s\t %s\t",  acc1.getValue(),acc2.getValue(),acc3.getValue());

    }
}
