package MyUtils;

import java.sql.Time;

public class MyTimer {
    private static long start;
    private static long finish;
    private static long time;

    public static long getTimerTime() {
        return time;
    }

    public static void startTimer(Thread thread) {
        start = System.currentTimeMillis();
        while (thread.isAlive())
        finish = System.currentTimeMillis();

        time = finish - start;

    }


    private MyTimer() {

    }

}
