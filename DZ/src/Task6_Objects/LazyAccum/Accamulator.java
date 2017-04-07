/**
 *
 */
package Task6_Objects.LazyAccum;

public class Accamulator implements Operation{

    double value;
    List list;
    public Accamulator(int num, List list){
        this.value=num;
        this.list=list;
    }


    public void add(int num, Operation operation) {
        Item item = new Item(num,operation);
        list.add(item);

    }

    public double calc() {
        for (Object o : list) {
            Item item = (Item) o;
            value = item.operation.apply(value,item.value);
        } return value;
    }

    @Override
    public double apply(double a, double b) {
        return 0;
    }


    public static class Item{
        Operation operation;
        double value;


     Item(int value,Operation operation){
         this.operation = operation;
         this.value = value;
     }

    }
}