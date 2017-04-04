/**
 *
 */
package Market;
import java.util.Scanner;
public class Transaction {

    int sum; //счётчик количетва сделок
    static private double balance = 1600; // баланс магазина
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

               {     System.out.println("Столько "+ input +" нет на складе");
               inputQuantity =  inputQuantity();
                }
             {
                 basket(input,inputQuantity,product);}
                System.out.println("На балансе магазина "+ balance + " $");

                Stock.stockBalance(product);
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
    private static void basket(String string, int q,Product[] product ){
        double price=0.0;
        for (int i = 0; i <product.length ; i++) {
            if (string.equals(product[i].name)) { price = product[i].getPrice();}
        }
             double sum;
           while ((sum = Product.getPriceDeal(price,q)) > (User.getUserBalance())){
               System.out.println("У вас недостаочно денег на счёте!");
               checkInputQantity(string,q=inputQuantity(),product);}
        System.out.println("Ваша корзина сформирована:");
        System.out.printf("%s %s шт %s$\n",string,q,sum);

        makeTransaction(string,q,sum,product);// подтверждение транзакции с изменением баланса склада

        User.printStockList(product);
        
    }

    private static double makeTransaction(String string,int q,double sum,Product[] product) {
         String inputStr =inputAccept() ;
        while (!accept(inputStr)){
            System.out.println("Введите либо положительный ответ, либо отрицательный ");
            inputStr =inputAccept();}

        for (int i = 0; i <product.length ; i++) {
            if ((product[i].name).equals(string)){ product[i].quantity = product[i].quantity - q ; }
        }
        return balance = balance + sum ; }

    // метод ввода с консоли подтверждения совершения транзакции
    private static String inputAccept(){
        System.out.print("Подтвердите транзакцию:");
        Scanner scanner = new Scanner(System.in);
        String  inputAccetr =  scanner.nextLine();
        return inputAccetr;
    }

     private static  boolean accept(String s){

        while (!s.equals("yes") && !s.equals("y") && !s.equals("Yes") && !s.equals("YES") && !s.equals("Y")){
            return false;}
        return true;
    }

    }

