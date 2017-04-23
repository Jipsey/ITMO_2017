package Patterns.Builder;

public class Pizza {
    private Dough dough ;
    private Toppings toppings;
    private Souce sauce;

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(Toppings toppings) {
        this.toppings = toppings;
    }

    public void setSouce(Souce sauce) {
        this.sauce = sauce;
    }

    enum Dough{LAYERED, SOLID}
    enum Toppings{CHEESE_CAMAMDER, CHEESE_GAUDA, BACON, SALAMI, ANANAS}
    enum Souce{TOMATO_SAUCE, CHESE_SAUCE, HOT_CHILLI_SAUCE, MASHROOM_SAUCE}

    @Override
    public String toString() {
        return "Pizza contains: " +
                "dough=" + dough +
                ", toppings=" + toppings +
                ", sauce=" + sauce;
    }

}

