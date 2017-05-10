package Bank;

import static MyUtils.RandmomMy.random;

public class Account {
    int id;
    String userName;
    int balance;

    protected Account(int id, String userName, int balance) {
        this.id = Math.abs((userName+balance+id).hashCode()); // создаём уникальный HashCode
        this.userName = userName;
        this.balance = balance;
    }

    public Account() {

    }


    static String castName() {
        Names[] arr = Names.values();
        int max = arr.length - 1;

        return arr[random(0, max)].toString();
    }


    enum Names {Alex, Ekaterina, Olga, Dmitriy, Ivan, Anna, Eugeniy, Tatiana, Egor, Igor, Vladimir, Petr}
}
