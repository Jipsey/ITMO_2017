package Patterns.Builder;


import java.util.Collection;
import java.util.HashSet;

public class Top5 {

public static class PizzaMargaritta extends PizzaBuilder{
    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {
        Collection<Pizza.Toppings> toppings = new HashSet<>();
                toppings.add(Pizza.Toppings.SALAMI);
                toppings.add(Pizza.Toppings.CHEESE_CAMAMDER);

                pizza.setToppings(toppings);
                }

    @Override
    public void buildSauce() { pizza.setSouce(Pizza.Souce.TOMATO_SAUCE);}
}

public static class PizzaNapoli extends PizzaBuilder{
    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {
        Collection<Pizza.Toppings> toppings = new HashSet<>();
        toppings.add(Pizza.Toppings.BACON);
        toppings.add(Pizza.Toppings.CHEESE_GAUDA);

        pizza.setToppings(toppings);
    }

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.MUSHROOM_SAUCE);}

}
public static class PizzaFourCheeses extends PizzaBuilder{

    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.LAYERED);}

    @Override
    public void buildToppings() {
        Collection<Pizza.Toppings> toppings = new HashSet<>();
        toppings.add(Pizza.Toppings.CHEESE_GAUDA);
        toppings.add(Pizza.Toppings.CHEESE_CAMAMDER);
        toppings.add(Pizza.Toppings.CHEESE_MOZZARELLA);
        toppings.add(Pizza.Toppings.CHEESE_RUSSIAN);

        pizza.setToppings(toppings);

    }

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.MUSHROOM_SAUCE);

    }
}

public static class PizzaFourSeasons extends PizzaBuilder {
    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {

        Collection<Pizza.Toppings> toppings = new HashSet<>() ;
        toppings.add(Pizza.Toppings.ANANAS);
        toppings.add(Pizza.Toppings.SALAMI);
        toppings.add(Pizza.Toppings.CHEESE_MOZZARELLA);

        pizza.setToppings(toppings);

    }

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.HOT_CHILLI_SAUCE);

    }
}

public static class PizzaHawaii extends PizzaBuilder{

    @Override
    public void buildDough() {pizza.setDough(Pizza.Dough.SOLID);}

    @Override
    public void buildToppings() {
        Collection <Pizza.Toppings> toppings = new HashSet<>();
        toppings.add(Pizza.Toppings.ANANAS);
        toppings.add(Pizza.Toppings.CHEESE_GAUDA);
        toppings.add(Pizza.Toppings.BACON);

        pizza.setToppings(toppings);

    }

    @Override
    public void buildSauce() {pizza.setSouce(Pizza.Souce.CHEESE_SAUCE);

    }
}
}

