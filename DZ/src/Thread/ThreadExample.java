package Thread;

public class ThreadExample {
    public static void main(String[] args) {

       // System.out.println(Thread.MyThread.currentThread().getName());

       // Thread.MyThread thread = new Thread.MyThread(new My());
       // thread.run();
    }

    private static class My implements Runnable{
        @Override
        public void run() {

            System.out.println();

        }
    }
}
