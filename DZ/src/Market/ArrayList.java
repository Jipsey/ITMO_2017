package Market;

/**
 *
 */
public class ArrayList {

    int volume =10;// вместимость склада
     int num = volume;// счётких пустых ячеек в аррайлисте
    Product [] stock = new Product[volume];


    public void makeBigger(){
        this.volume=volume*2;
        this.stock = new Product[volume];

    }

}
