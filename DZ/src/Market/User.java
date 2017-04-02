package Market;

import java.util.Scanner;

/**
 *
 */

public class User {
    String name = "Aleksandr";
    int id = name.hashCode();
    double userBalance = 650;


            public void login() {

                    checkNameEnter();
                    while (!checkNameEnter().equals(this.name)) {
                           checkNameEnter();
                        if(!checkNameEnter().equals(this.name)){
                            System.out.println("ввведёный пользователь в системе не зарегестрирован");}
                    }
                System.out.println("у вас на счете: " + getUserBalance() + "$");}


    public String checkNameEnter() {
        System.out.print("Введите имя пользователя: ");
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public double getUserBalance() {

                return userBalance;
    }

    public int getId() {
        return id;
    }
}
