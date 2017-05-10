package Bank;

public class Account{
    int id;
    String userName;
    int balance;

    protected Account(int id, String userName, int balance) {
        this.id = id;
        this.userName = userName;
        this.balance = balance;
    }

    public Account(){

    }


}
