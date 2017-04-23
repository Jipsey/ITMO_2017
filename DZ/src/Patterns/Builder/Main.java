package Patterns.Builder;

public class Main {

    public static void main(String[] args) {
       Director director = new Director();
       PizzaBuilder newPizza = new Top5.PizzaFourCheeses();

         director.setPizzaBuilder(newPizza);
         director.make();

        System.out.println(newPizza);
    }

}
