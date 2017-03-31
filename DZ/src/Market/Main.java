/**
 *
 */
package Market;


public class Main {


    public static void main(String[] args) {

       Stock stock = new Stock();
       stock.setStockValue();
       stock.put(stock.pen,5);

       System.out.println();

        stock.print();
    }


}
