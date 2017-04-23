package Patterns.Builder;

abstract public class PizzaBuilder {
protected Pizza pizza;

public Pizza getPizza() {return this.pizza;}

public void createNewPizza() {this.pizza= new Pizza();}

public abstract void buildDough();
public abstract void buildToppings();
public abstract void buildSauce();

    @Override
    public String toString() { return  pizza.toString(); }
}
