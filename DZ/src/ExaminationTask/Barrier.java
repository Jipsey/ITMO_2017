package ExaminationTask;

public class Barrier {
    private static int cnt;

    public Barrier(int x) {
        cnt = x;
    }

    private static int getCounter() {
        return cnt;
    }

    private static void decrCounter() {
        cnt--;
    }

    public void ready() {


        if (Barrier.getCounter() == 1) {
            System.out.println("через 5 секунд потоки проснуться : )");
            for (int i = 0; i < 5; i++) {

                try {
                    Thread.sleep(1000);
                    System.out.print(". ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            notifyAll();
            System.out.println("Поток " + Thread.currentThread().getName() + " разбудил все остальные потоки");
        }
        while (Barrier.getCounter() > 1) {
            try {
                decrCounter();
                System.out.println("Поток " + Thread.currentThread().getName() +
                        " зашёл в блок try ");

                wait();

                System.out.println("Поток " + Thread.currentThread().getName() +
                        " вышел с паузы и завершает работу");
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}

