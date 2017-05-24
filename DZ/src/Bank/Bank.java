package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static MyUtils.RandmomMy.random;


public class Bank {

    private static int num = 10;               // количество транзакций
    private static int accNum = 10;            // количество аккаунтов
    private static List<Account> accountList;  // список аккаунтов
    private volatile static BlockingQueue<ResultOfTransaction> blockingQueue;
    static ExecutorService pool;


    public Bank(int qtyTransactions, int qtyAccounts, int qtyThreads) {
        num = qtyTransactions;
        accNum = qtyAccounts;
        blockingQueue = new LinkedBlockingQueue<>();
        accountList = new ArrayList<>(accNum);
        pool = Executors.newFixedThreadPool(qtyThreads);
        makeAccountList();  // создаем лист аккаунтов
        printAccountList(); // выводим на консоль все аккаунты;
        getTotalBalance();  // выводим на консоль общий баланс всех аккаунтов
        MailerThread mailerThread = new MailerThread();
        mailerThread.start();

    }


    public static void makeAccountList() {
        for (int i = 0; i < accNum; i++) {
            accountList.add(new Account(i, Account.castName(), random(200, 900)));
        }
    }

    private static Account getAccount() {
        return accountList.get(random(0, accountList.size() - 1));
    }


    public static void getTotalBalance() {
        int totlaBalance = 0;

        for (Account account : accountList) {
            totlaBalance += account.getBalance();
        }

        System.out.println(totlaBalance + " $");
    }

    public static void printAccountList() {

        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    public static void transfer() {
        for (int i = 0; i < num; i++) {
            new Transaction(getAccount(), getAccount(), random(250, 380));
        }
    }

    private static class Transaction implements Callable<Boolean> {
        private Account losingMoney;
        private Account receivingMoney;
        private int amount;
        private static boolean status;


        public Transaction(Account losingMoney, Account receivingMoney, int amount) {
            this.losingMoney = losingMoney;
            this.receivingMoney = receivingMoney;
            this.amount = amount;
            while (losingMoney.getId() == receivingMoney.getId()) {
                losingMoney = getAccount();
            }
            this.losingMoney = losingMoney;
            status = transferMoney(losingMoney, receivingMoney, amount);
            pool.submit(this);
        }

        public boolean transferMoney(Account losingMoney, Account receivingMoney, int amount) {
            if (losingMoney.getBalance() >= amount) {
                int lm = losingMoney.getBalance();
                int rm = receivingMoney.getBalance();

                losingMoney.setBalance(lm - amount);
                receivingMoney.setBalance(rm + amount);
                return true;
            }
            return false;
        }

        @Override
        public Boolean call() throws Exception {
            blockingQueue.offer(new ResultOfTransaction(this));
            return status;
        }

        @Override
        public String toString() {
            return "Transaction: " +
                    "losingMoney " + losingMoney +
                    ", receivingMoney " + receivingMoney +
                    ", amount=" + amount +
                    ", status=" + status +
                    '}';
        }
    }

    public class MailerThread extends Thread {

        public MailerThread() {
            new Thread(this);
        }

        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ResultOfTransaction r;
                    while ((r = blockingQueue.take()) != null) {
                        System.out.print(r + "\t");
                        if (r.isResult()) {
                            System.out.println("------------ ^ транзакция прошла успешно! ^------------");

                        } else {
                            System.out.println("------------ ^ транзакция невозможна! ^ ------------");

                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                Thread.currentThread().interrupt();
            }
        }
    }


    private static class ResultOfTransaction {

        private Transaction transaction;
        private boolean result;

        public boolean isResult() {
            return result;
        }

        @Override
        public String toString() {
            return "Транзакция: \n" +
                    transaction.losingMoney + "\n" +
                    transaction.receivingMoney + "\n" +
                    "сумма перевода " + transaction.amount + " $\n"
                    + "-----------------------------------";
        }

        public ResultOfTransaction(Transaction transaction) {
            this.transaction = transaction;
            this.result = Transaction.status;

        }
    }
}

