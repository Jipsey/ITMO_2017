package Bank;


import static MyUtils.RandmomMy.random;

public class Account {
    private int id;
    private String userName;
    private int balance;


    Account(int id, String userName, int balance) {
        this.id = Math.abs((userName + balance + id).hashCode()); // создаём уникальный HashCode
        this.userName = userName;
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    int getBalance() {
        return balance;
    }

    static String castName() {
        Names[] arr = Names.values();
        int max = arr.length - 1;

        return arr[random(0, max)].toString();
    }



    @Override
    public String toString() { return
        "User: " + userName +"\t"
        + "id: " + id +"\t" + "Balance: " + balance + " $";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (balance != account.balance) return false;
        return userName.equals(account.userName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userName.hashCode();
        result = 31 * result + balance;
        return result;
    }

    enum Names {Alex, Ekaterina, Olga, Dmitriy, Ivan, Anna, Eugeniy, Tatiana, Egor, Igor, Vladimir, Petr}
}
