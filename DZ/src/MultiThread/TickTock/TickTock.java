package MultiThread.TickTock;

import static java.lang.Thread.sleep;

// использование методов wait() и notify() для имитации часов
public class TickTock {

    String state;

    synchronized void tick(boolean running) {
        if (!running) { // остановить часы
            state = "ticked";
            notify(); // уведомить ожидающие потоки
            return;
        }
        System.out.print("Tick ");
        state = "ticked"; // установить текущее состояние
        // после такта "тик"
        try {
            sleep(1000);
            notify();// позволить выполнять методу tock()
            while (!state.equals("tocked"))
                wait(); // ожидать до завершения метода tock()
        }
        catch (InterruptedException ex){
            System.out.println("Прерывание потока ");
        }
    }

    synchronized void tock(boolean running){
        if(!running){//остановить часы
            state ="tocked";
            notify();// уведомить ожидающие потоки
            return;
        }
        System.out.println("Tock");

        state = "tocked"; // установить ткущее значение состояние
        // после такта "так"
        try {
            sleep(1000);
            notify();  // позволить выполняться методу tick()
            while (!state.equals("ticked"))
                wait();  // ожидать до завершения метод tick()
        }catch (InterruptedException exc){
            System.out.println("Прерывание потока" + exc);
        }
    }
}

