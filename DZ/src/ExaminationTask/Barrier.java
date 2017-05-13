package ExaminationTask;

public class Barrier{
    private static int cnt;
    public Barrier(int x) {
        this.cnt = x;
    }

    public static int getCounter() {
        return cnt;
    }

    public static void decrCounter(){
        cnt--;
    }
}
