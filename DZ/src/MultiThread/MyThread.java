package MultiThread;

import java.io.File;
import java.io.IOException;

public class MyThread {

    public static void main(String[] args) throws InterruptedException, IOException {

        Thread thread = new Thread(new InterruptibleThread());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();


    }

    public static class InterruptibleThread implements Runnable {
        private int cnt;

        @Override
        public void run (){

            System.out.printf("Поток %s начал работу!\n", Thread.currentThread().getName());
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Counter: "+ cnt++);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.err.println("Поток прерван !");
                return;
            }
            System.out.printf("Поток %s завершил работу\n", Thread.currentThread().getName() );
        }
        }
    }
}

