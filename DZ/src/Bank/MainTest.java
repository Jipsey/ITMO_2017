package Bank;


import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        int num = 10;
        BankTransactions btr = new BankTransactions();
        List<Thread> listThread = new ArrayList<>(num);
        List<BankTransactions> listTransactions = new ArrayList<>(num);
        Account ac = new Account();

        for (int i = 0; i < num; i++) {
            listTransactions.add(new BankTransactions(
                    new Account(i, Account.castName(), 500),
                    new Account(-i, Account.castName(), 500), 120));
        }


        BankTransactions.makeTransactionsQueue(listTransactions);

        for (int j = 0; j < listTransactions.size(); j++) {
            listThread.add(btr.new MailerThread("#" + j));
        }

        for (Thread thread : listThread) {
            thread.start();
        }

        for (Thread thread : listThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
