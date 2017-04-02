/**
 *
 */
package Market;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        User user = new User();
        user.login();
        //transaction.invoce();


       Stock stock = new Stock() ;

        ArrayList arrL = new ArrayList();
        arrL.add(stock.coin, 10);
        arrL.add(stock.comics,7);
        arrL.add(stock.chair,6);



        arrL.print(arrL.stock);

        System.out.println();
        System.out.println("свободных мест на складе:  " + arrL.num);

        System.out.println("вместимость склада:  " + arrL.volume);
        System.out.println("на складе " + stock.coin.name +" " + stock.coin.getQuantity(stock.coin));
    }


}
