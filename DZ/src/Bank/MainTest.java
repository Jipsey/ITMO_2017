package Bank;


import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        int num =10;

        Account acc = new Account();
        List<Thread> listThread = new ArrayList<>(num);
        List<BankTransactions> listTransactions = new ArrayList<>(num);
         for (Thread thread: listThread){
             listThread.add(new MailerThread())

         }

        for (Thread thread : listThread) {
            thread.start();
        }

        for (Thread thread : listThread) {
            thread.join();
        }


        int i=0;
        for (BankTransactions bt:listTransactions) {
            listTransactions.add(new BankTransactions(
                    new Account(i+1,"Alex",500),
                    new Account(i+2,"Ekaterina",500),120 ));
                    i++;
        }




        }
    }
