/**
 *
 */
package Market;

import java.util.Scanner;

//import static Market.Product.getQuantity;

public class Main {


    public static void main(String[] args) {
        User user = new User();
        user.login();
        //transaction.invoce();


       Stock stock = new Stock() ;

        ArrayList arrL = new ArrayList();
        arrL.add(stock.coin, 2);
        arrL.add(stock.comics,2);
        arrL.add(stock.chair,3);



     //        arrL.print(arrL.stock);


        System.out.println("список товров на складе:");
        Stock.stockBalance(arrL.stock);

    }



}
