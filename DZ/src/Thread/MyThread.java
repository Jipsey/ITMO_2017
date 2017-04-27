package Thread;

public class MyThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new InterruptibleThread());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();

    }

    public static class InterruptibleThread implements Runnable {
        private int cnt;


        public void run (){

            System.out.printf("Поток %s начал работу!\n", Thread.currentThread().getName());
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Counter: "+ cnt++);
            try {
                Thread.sleep(1000);

            }
            catch (InterruptedException e){
                System.err.println("Поток прерван !");
            }
            System.out.printf("Поток %s завершил работу\n", Thread.currentThread().getName() );

        }

        }
    }
}

