/**
 *
 */

package Market;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Transaction {

    int sum; //счётчик количетва сделок
    double balance; // баланс магазина
    Object date;
    int  total;// тут храним сумму сделки
    Object [] dealList = new Object[sum+1]; //в этом массиве храним список сделок

    // метод для совершения транзакции, сначалла пользователь выбирает товар по имени,
    // затем вводит количество товаров
    // после чего пользователю предлагается выбрать еще товар, либо завершить покупки.
    public static  void deal(Product[] product){

           String input = input();

           while(!checkInput(input, product)){System.out.println("такого товара нет на складе");
            input = input();}

            {  int inputQuantity =  inputQuantity();

               while (!checkInputQantity(input,inputQuantity,product))
                //&&
                 //       (Product.getPriceDeal(product[2].getPrice(),inputQuantity))> User.getUserBalance()
                   //     )
                 //{
                    //if (Product.getPriceDeal(product[3].getPrice(),inputQuantity)> User.getUserBalance()){
                    //System.out.println("У вас не достаточно денег, пизмените количесво ");
               {inputQuantity =  inputQuantity();
                }   //else
                    System.out.println("Столько "+ input +" нет на складе");
                    inputQuantity =  inputQuantity();
                //}
             //{
             {
                 basket(input,inputQuantity,product);}
             }
         }
         //}

      // метод ввода с консоли наименования товара
      private static String input(){
          System.out.println("выберете товар из списка, путём ввода названия товара");
          Scanner scanner = new Scanner(System.in);
          String  input =  scanner.nextLine();
          return input;
      }

      // метод ввода с консоли количества товаров
      private static int inputQuantity(){
          System.out.println("сколько будете покупать ?(введите количество шт)");
          Scanner   scannerQ = new Scanner(System.in);
          int inputQuantity =  scannerQ.nextInt();
          return inputQuantity;
      }

      // метод проверки наличия введенного пользователем товара и возврата индека товара в массиве
     private static boolean checkInput(String string,Product[] product){
        for (int i = 0; i <product.length ; i++) {
           if(string.equals(product[i].name))  return true;
         } return false;
     }

    // метод проверки наличия введенного пользователем товара
    private static boolean checkInputQantity(String string,int q,Product[] product){
        for (int i = 0; i <product.length ; i++) {
            if(string.equals(product[i].name)){
               if((product[i].quantity)>=q) return true;}
        } return false;
    }

    // метод формирующий корзину покупателя
    public static void basket(String string, int q,Product[] product ){
        double price=0.0;
        for (int i = 0; i <product.length ; i++) {
            if (string.equals(product[i].name)) { price = product[i].getPrice();}
        }
           double sum = Product.getPriceDeal(price,q);
           while (sum > (User.getUserBalance())){
               System.out.println("У вас недостаочно денег на счёте!");
               checkInputQantity(string,inputQuantity(),product);}
        System.out.println("Ваша корзина сформирована:");
        System.out.printf("%s %s шт %s$ ",string,q,sum);
    }

    public double getTotal() { return total; }
}
