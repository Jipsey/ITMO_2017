package Patterns.Builder;


public class Top5 {

public static class PizzaMargaritta extends PizzaBuilder{
    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {pizza.setToppings(Pizza.Toppings.SALAMI);}

    @Override
    public void buildSauce() { pizza.setSouce(Pizza.Souce.TOMATO_SAUCE);}
}

public static class PizzaNapoli extends PizzaBuilder{
    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {pizza.setToppings(Pizza.Toppings.CHEESE_CAMAMDER);}

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.MASHROOM_SAUCE);}

}
public static class PizzaFourCheeses extends PizzaBuilder{

    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.LAYERED);}

    @Override
    public void buildToppings() {pizza.setToppings(Pizza.Toppings.CHEESE_GAUDA);}

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.CHESE_SAUCE);

    }
}

public static class PizzaFourSeasons extends PizzaBuilder {
    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {pizza.setToppings(Pizza.Toppings.BACON);}

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.HOT_CHILLI_SAUCE);

    }
}

public static class PizzaHawaii extends PizzaBuilder{

    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {pizza.setToppings(Pizza.Toppings.ANANAS);}

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.TOMATO_SAUCE);

    }
}
}

