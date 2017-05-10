package Bank;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;


public class BankTransactions {

    private static BlockingQueue<BankTransactions> blockingQueue;
    private static boolean status = false;
    static Iterator<String> iteratorQueue;

    Account losingMoney;
    Account receivingMoney;
    int amount;


    public BankTransactions(Account losingMoney, Account receivingMoney, int amount) {
        this.losingMoney = losingMoney;
        this.receivingMoney = receivingMoney;
        this.amount = amount;
        transferMoney(losingMoney,receivingMoney,amount);
    }

    private static boolean getStatus() {
        return status;
    }


    public static boolean transferMoney(Account losingMoney, Account receivingMoney, int amount) {
        if (amount <= losingMoney.balance) {
            losingMoney.balance -= amount;
            receivingMoney.balance += amount;
            status = true;
        }
         return getStatus();
    }


    public class MailerThread extends Thread{

        Account losingMoney;
        Account receivingMoney;
        int amount;

        public MailerThread(String name,Account losingMoney,Account receivingMoney,int amount) {
            this.losingMoney = losingMoney;
            this.receivingMoney = receivingMoney;
            this.amount = amount;
            new Thread(this);
            setName(name);
        }

        @Override
        public void run() {
            if(BankTransactions.transferMoney(losingMoney,receivingMoney,amount))
                System.out.printf("Транзакция %s прошла успешно!\n",getName());
            else System.err.printf("Транзакция %s невозможна!\n",getName());
        }
    }


    public static void startQueue (){
            while (iteratorQueue.hasNext()) {

            }
        }

}
