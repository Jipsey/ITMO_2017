/**
 *
 */
package Market;

public  class Product {
    private int id =0;
    private String name;
    private double price;
    int quantity;


   public Product(int quantity ){
       this.quantity=quantity;
   }
   public Product(String name, int id, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

     public double getPriceDeal(int quantity){
       return price*quantity;
     }

    @Override
    public String toString() {
        return "product: " + id +'\t' + name + '\t' + price +  "$\t" + quantity + " pcs";
    }
}
