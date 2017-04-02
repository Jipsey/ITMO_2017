/**
 *
 */
package Market;

public  class Product {

    public String name;
    private int id =0;
    private double  price;
    public int quantity;

   public Product(int quantity){
       this.quantity = quantity;
   }
   public Product(String name, int id, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // метод для подсчета количества продуктов на складе
     public int getQuantity(Product product){
         int counter=0;
         for (int i = 0; i <(new ArrayList()).stock.length ; i++) {
             ArrayList arrL = new ArrayList();
           if ( (product.name).equals( arrL.stock[i].name )){counter++;}
         }
         return counter;
     }

     public double getPriceDeal(int quantity){
       return price*quantity;
     }




    @Override
    public String toString() {
        return "product: " + id +'\t' + name + '\t' + price +  "$\t" ;
    }
   }
