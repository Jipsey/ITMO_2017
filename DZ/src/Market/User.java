package Market;

import java.util.Scanner;

/**
 *
 */

public class User {
    String name = "Aleksandr";
    int id = name.hashCode();
    double userBalance = 650;

        // метод для логина пользователя
            public void login() {
                    //checkNameEnter();
                    if (checkNameEnter().equals(this.name)){
                        System.out.println("у вас на счете: " + getUserBalance() + "$");
                    }
                        else{
                    while (!checkNameEnter().equals(this.name)) {
                           checkNameEnter();
                           }}
                    getUserBalance();
                     }

        // метод проверки введенного имени пользователя

    private String checkNameEnter() {
        System.out.print("Введите имя пользователя: ");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        if (!scan.equals(this.name)){System.out.println("введёный пользователь в системе не зарегестрирован");}
        return scan;
    }


    public double getUserBalance() {

                return userBalance;
    }

    private int getId() {
        return id;
    }
}
