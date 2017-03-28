package Task6_Objects;

/**
 *
 */

public class Accumulator {

    int value;
    final Operation operator;

    public Accumulator(int value, Operation operator){
        this.value = value;
        this.operator = operator;

    }

    public void calculate (int a){ value = operator.apply(value, a);}

    int getValue(){
        return value;}

    }


