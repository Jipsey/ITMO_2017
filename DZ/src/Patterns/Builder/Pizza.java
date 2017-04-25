package Patterns.Builder;

import java.util.Collection;

public class Pizza {
    private Dough dough ;
    private Collection <Toppings> toppings;
    private Sauce sauce;
    private String pizzaName;

    enum Dough{LAYERED, SOLID}
    enum Toppings{CHEESE_CAMAMBER, CHEESE_GAUDA, BACON, SALAMI, ANANAS, CHEESE_RUSSIAN, CHEESE_MOZZARELLA}
    enum Sauce{TOMATO_SAUCE, CHEESE_SAUCE, HOT_CHILLI_SAUCE, MUSHROOM_SAUCE}


    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(Collection<Toppings> topping) {
        this.toppings = topping;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public void setPizzaName(String name){
        this.pizzaName = name;
    }

    @Override
    public String toString() {
        return  pizzaName + " contains: " +
                "dough=" + dough +
                ", toppings=" + toppings +
                ", sauce=" + sauce;
    }

}

