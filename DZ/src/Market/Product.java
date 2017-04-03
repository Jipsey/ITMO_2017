/**
 *
 */
package Market;

public  class Product {

    public String name;
    private int id = 0;
    private double price;
    public int quantity;


    public Product(String name, int quantity) {
        name = name;
        quantity = quantity;

    }



    public Product(int quantity) {
        this.quantity = quantity;
    }


    public Product(String name, int id, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    // метод для подсчета количества продуктов на складе


    public static int getQuantityProduct(Product[] product, String name) {
        int counter = 0;
        for (int i = 0; i <product.length;i++) {
            if (product[i]==null){   }
            else if ((product[i].getName()).equals(name)) {
                counter++;}
    }
    return counter;
    }


    public double getPriceDeal(int quantity) {
        return price * quantity;
    }




    @Override
     public String toString() {
        return "product: " + this.id +'\t' + this.name + '\t' + this.price +  "$\t" ;
     }
    }
