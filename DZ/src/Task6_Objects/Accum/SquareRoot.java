package Task6_Objects.Accum;

import Task6_Objects.Accum.Operation;

/**
 *
 */
public class SquareRoot implements Operation {

    @Override
    public int apply(int a, int b) {
        return (int)Math.sqrt(a);
    }
}
