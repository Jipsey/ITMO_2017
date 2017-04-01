/**
 *
 */
package Market;
import java.util.Arrays;
import java.util.Scanner;


public class Stock {
    int id;// id продукта
    int volume ;// вместимость склада
    ArrayList arrList = new ArrayList();


    Product pen = new Product("pencil",id=1001,5.85);
    Product marker = new Product("marker",id=1021,4.35);
    Product comics = new Product("comics",id=2134,9.95);
    Product coin = new Product("coin",id=1245,34.25);
    Product notebook = new Product("notebook",id=7826,1200);
    Product table = new Product("table",id=8981,435);
    Product chair = new Product("chair",id=3451,76.5);


    public void setStockValue() {
        System.out.print("Введите количество продуктов на складе:");
        Scanner sc = new Scanner(System.in);
        arrList.volume = sc.nextInt();
        }

        int i =0;
    public void put(Product product, int quantity){

        while (arrList.stock[i]!=null && arrList.num != 1 ){i++;}

        if (arrList.num>1){
        product.quantity = quantity;
            arrList.stock[i] = product;
            i++;arrList.num--;
        if (arrList.num <= 1){arrList.makeBigger();
            System.out.println("Объём нового аррайЛиста: " + arrList.volume);
           arrList.num = arrList.volume; i=0;
        }
        }}





    public void print(){
        for (int i = 0; i < arrList.stock.length ; i++) {

        System.out.println(arrList.stock[i]);
    }}

}
