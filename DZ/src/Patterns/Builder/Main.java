package Patterns.Builder;

public class Main {

    public static void main(String[] args) {
       Director director = new Director();
       PizzaBuilder margarita = new Top5.PizzaMargaritta();

         director.setPizzaBuilder(margarita);
         director.make();

        System.out.println(margarita);
    }

}
