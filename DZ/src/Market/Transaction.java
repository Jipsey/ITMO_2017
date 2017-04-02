package Market;

/**
 *
 */
public class Transaction {

    int sum; //счётчик количетва сделок
    double balance; // баланс магазина
    Object date;
    int  total;// тут храним сумму сделки
    Object [] dealList = new Object[sum+1]; //в этом массиве храним список сделок







    public double getTotal() { return total; }
}
