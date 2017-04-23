package Patterns.Builder;

public class Director {
   PizzaBuilder pizzaBuilder;

   public void setPizzaBuilder(PizzaBuilder pizzaBuilder){
       this.pizzaBuilder = pizzaBuilder;
   }

   public Pizza getPizza(){
       return pizzaBuilder.getPizza();
   }


   public void make(){
       pizzaBuilder.createNewPizza();
       pizzaBuilder.buildDough();
       pizzaBuilder.buildSauce();
       pizzaBuilder.buildToppings();
   }
}
