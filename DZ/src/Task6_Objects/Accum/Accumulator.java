package Task6_Objects.Accum;

/**
 *
 */

public class Accumulator {

    int value;
    private Operation operation;

    public Accumulator(int value, Operation operation){
        this.value = value;
        this.operation = operation;
    }

    public void calculate (int b){ value = operation.apply(value, b);}

    int getValue(){
        return value;}

    }