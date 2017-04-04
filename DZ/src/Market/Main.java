/**
 *
 */
package Market;


public class Main {

    public static void main(String[] args) {

        ArrayList arrL = new ArrayList();
        Stock stock = new Stock() ;

        arrL.add(stock.coin, 2);
        arrL.add(stock.comics,2);
        arrL.add(stock.chair,16);
        arrL.add(stock.notebook,8);
        arrL.add(stock.pen,35);

        User.login(arrL.stock);

        Stock.stockBalance(arrL.stock);

        Transaction.deal(Stock.stockBalance(arrL.stock));


    }



}
