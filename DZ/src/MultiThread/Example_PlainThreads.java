package MultiThread;

/**
 * Created by xmitya on 08.12.16.
 */
public class Example_PlainThreads {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptibleThread());

        thread.start();

        Thread.sleep(3000);

        thread.interrupt();
    }

    public static class InterruptibleThread implements Runnable {
        private int cnt;

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Hello " + ++cnt);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
//                    throw new RuntimeException("Oh my!", e);
//                    MultiThread.currentThread().interrupt();
                    return;
                }
            }
        }
    }


}
