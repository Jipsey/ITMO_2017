package Patterns.Builder;

import java.util.Collection;

public class Pizza {
    private Dough dough ;
    private Collection <Toppings> toppings;
    private Souce sauce;

    enum Dough{LAYERED, SOLID}
    enum Toppings{CHEESE_CAMAMDER, CHEESE_GAUDA, BACON, SALAMI, ANANAS, CHEESE_RUSSIAN, CHEESE_MOZZARELLA}
    enum Souce{TOMATO_SAUCE, CHEESE_SAUCE, HOT_CHILLI_SAUCE, MUSHROOM_SAUCE}


    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(Collection<Toppings> topping) {
        this.toppings = topping;
    }

    public void setSouce(Souce sauce) {
        this.sauce = sauce;
    }


    @Override
    public String toString() {
        return "Pizza contains: " +
                "dough=" + dough +
                ", toppings=" + toppings +
                ", sauce=" + sauce;
    }

}

