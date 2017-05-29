package ExaminationTask;

public class Barrier {
    private int cnt;

    public Barrier(int x) {
        cnt = x;
    }

    public void ready() throws InterruptedException {
        synchronized (this) {
            cnt--;

            if (cnt == 0) {
                notifyAll();
            }
            while (cnt > 0) {
                wait();
            }
        }
    }
}