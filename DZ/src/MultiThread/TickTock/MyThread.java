package MultiThread.TickTock;

/**
 * Created by Екатерина on 03.05.2017.
 */
class MyThread implements Runnable{
    Thread thrd;
    TickTock ttOb;

    // Создать новый поток.
   MyThread(String name, TickTock tt){
       thrd = new Thread(this,name);
       ttOb = tt;
              thrd.start();// запустить поток
    }

    @Override
    public void run() {
        if(thrd.getName().compareTo("Tick")==0){
            for (int i=0;i<5;i++)ttOb.tick(true);
            ttOb.tick(false);
        }
        else{
            for(int i=0;i<5;i++)ttOb.tock(true);
            ttOb.tock(false);
        }


    }
}
