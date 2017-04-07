package Market;


/**
 *
 */
import java.util.Scanner;

public class User {
    public static String name = "Aleksandr";
    int id = name.hashCode();
    public static double userBalance = 650;
    private static int usersQantity = 5;




        // метод для логина пользователя
            public static void login(Product[] object) {


                    if (checkNameEnter().equals(name)){
                        System.out.println("у вас на счете: " + getUserBalance() + "$");
                    }
                        else{
                    while (!checkNameEnter().equals(name)) {
                           checkNameEnter();
                           } System.out.println("у вас на счете: " + getUserBalance() + "$");}
                    getUserBalance();

                    System.out.println("список товров на складе:");
                    object = Stock.stockBalance(object);

                    printStockList(object);
                     }

        // метод проверки введенного имени пользователя
    private static String checkNameEnter() {
        System.out.print("Введите имя пользователя: ");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        if (!scan.equals(name)){System.out.println("введёный пользователь в системе не зарегестрирован");}
        return scan;
    }
      // метод для вывода на печать массива - склада в нужном нам виде
   public static void  printStockList(Object[] object){
        System.out.println("************************");
        for (int i = 0; i < object.length; i++) {

            Product[] product = (Product[]) object; // приводим Object[] к типу Product[] !
            System.out.println("№" + (i+1) + "\t" + product[i].getName() + "\t" + product[i].quantity +" шт\t"
                    + product[i].getPrice() + "$"
            );} System.out.println("************************");
    }


    public static double getUserBalance() {
                return userBalance;
    }
}


