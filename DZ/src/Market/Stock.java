/**
 *
 */
package Market;

import java.util.Scanner;

public class Stock {
    int id;// id продукта
    int volume ;// вместимость склада
    Product [] stock = new Product[volume];

    Product pen = new Product("pencil",id=1001,5.85);
    Product marker = new Product("marker",id=1021,4.35);
    Product comics = new Product("comics",id=2134,9.95);
    Product coin = new Product("coin",id=1245,34.25);
    Product notebook = new Product("notebook",id=7826,1200);
    Product table = new Product("table",id=8981,435);
    Product chair = new Product("chair",id=3451,76.5);


    public int setStockValue() {
        System.out.print("Введите количество продуктов на складе:");
        Scanner sc = new Scanner(System.in);
        volume = sc.nextInt();
        return volume;}


    public void put(Product product, int quantity){
        quantity = product.quantity;
        for (int i = 0; i <stock.length ; i++) {
            stock[i] = product;
        }
    }


    public void print(){
        for(int i=0; i<stock.length;i++){
        System.out.println(stock[i]);
        }
    }

}
