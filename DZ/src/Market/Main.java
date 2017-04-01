/**
 *
 */
package Market;


public class Main {


    public static void main(String[] args) {

       Stock stock = new Stock() ;
      // stock.setStockValue();

        for (int i=0;i<9;i++) {
            stock.put(stock.pen, 5);
        }

        stock.print();

        System.out.println("всего мест на складе:  " + stock.arrList.volume);

        System.out.println("свободных мест на складе:  " + stock.arrList.num);
    }


}
