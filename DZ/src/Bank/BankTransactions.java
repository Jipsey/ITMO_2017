package Bank;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class BankTransactions {

    private static BlockingQueue<BankTransactions> blockingQueue = new LinkedBlockingQueue<>();
    private static boolean status = false;


    private Account losingMoney;
    private Account receivingMoney;
    private int amount;


    public BankTransactions(Account losingMoney, Account receivingMoney, int amount) {
        this.losingMoney = losingMoney;
        this.receivingMoney = receivingMoney;
        this.amount = amount;
    }

    public BankTransactions() {
    }

    private static boolean getStatus() {
        return status;
    }

    public static void makeTransactionsQueue(List<BankTransactions> listTransactions) {
        Iterator<BankTransactions> it = listTransactions.iterator();
        while (it.hasNext()) {
            blockingQueue.offer(it.next());

        }

    }

    public static boolean transferMoney(Account losingMoney, Account receivingMoney, int amount) {
        if (amount <= losingMoney.balance) {
            losingMoney.balance -= amount;
            receivingMoney.balance += amount;
            status = true;
        }
        return getStatus();
    }


    public class MailerThread extends Thread {
        BankTransactions bt;

        public MailerThread(String name) {
            setName(name);
            new Thread(this);
        }

        @Override
        public void run() {
            try {
                while ((bt = blockingQueue.take()) != null)

                    if (BankTransactions.transferMoney(bt.losingMoney, bt.receivingMoney, bt.amount))
                        System.out.printf("Транзакция %s прошла успешно!\n", getName());
                    else System.err.printf("Транзакция %s невозможна!\n", getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
