package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainTest {
    public static void main(String[] args) throws InterruptedException {

        int numThreads = 4;

        Bank bank = new Bank(10, 3, numThreads);

        Bank.transfer();
        Bank.pool.shutdown();

        System.out.println(Thread.activeCount());
        Bank.printAccountList();  // выводим на консоль все аккаунты;
        Bank.getTotalBalance();   // выводим на консоль общий баланс всех аккаунтов

    }
}
