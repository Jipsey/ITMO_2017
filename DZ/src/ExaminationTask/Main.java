package ExaminationTask;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        int qtyThreads = 3;

        ArrayList<Thread> listThread = new ArrayList<>();
        Barrier br = new Barrier(qtyThreads);

        for (int i = 0; i < qtyThreads; i++) {
            listThread.add(m.new MyThread(br, (i + 1) * 1000, "#" + i));
        }

        for (Thread thread : listThread) {
            thread.start();
        }

        for (Thread thread : listThread) {
            thread.join();
        }

    }


    public class MyThread extends Thread {
        Barrier br;
        int timeout;

        MyThread(Barrier br, int timeout, String name) {
            this.br = br;
            setName(name);
            this.timeout = timeout;
        }

        @Override
        public void run() {
            try {

                sleep(timeout);

                System.out.println(getName() + " ready!");

                br.ready();

                System.out.println(getName() + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}