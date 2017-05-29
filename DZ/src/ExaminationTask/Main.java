package ExaminationTask;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        int qtyThreads = 3;

        ArrayList<Thread> listThread = new ArrayList<>();
        Barrier br = new Barrier(qtyThreads);

        for (int i = 0; i < qtyThreads; i++) {
            listThread.add(m.new MyThread(br, qtyThreads, "#" + i));
        }

        for (Thread thread : listThread) {
            thread.start();
        }

        for (Thread thread : listThread) {
            thread.join();
        }

    }


    public class MyThread extends Thread {
        int qtyThreads;
        Barrier br;
        String name;

        MyThread(Barrier br, int qtyThreads, String name) {
            this.qtyThreads = qtyThreads;
            this.br = br;
            this.name = name;
            new Thread(this);
            setName(name);
        }

        @Override
        public void run() {
            synchronized (br) {


                br.ready();



        }
    }
}
}


