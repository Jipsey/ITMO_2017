/**
 *
 */
package Market;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;


public class Stock {
    int id;// id продукта

    Product pen = new Product("pencil", id = 1001, 5.85);
    Product marker = new Product("marker", id = 1021, 4.35);
    Product comics = new Product("comics", id = 2134, 9.95);
    Product coin = new Product("coin", id = 1245, 34.25);
    Product notebook = new Product("notebook", id = 7826, 1200);
    Product table = new Product("table", id = 8981, 435);
    Product chair = new Product("chair", id = 3451, 76.5);


        // метод оптимизации склада - массиа, с подсчетом количества позиций
        public static Product[] stockBalance (Product[] arr ) {
        Product head = null, current=null, next=null;
        int n=0;
        Product[] arrStockList = new Product[arr.length];
        for (int i = 0; i < arr.length;i++ ) {
            if ( arr[i] == null) {     }
            if ( arrStockList[n] != null && arrStockList[n].equals(arr[i])){head = arrStockList[n] ; n++;}
            if (arrStockList[n] == null)
                if (arr[i] != null && head != arr[i]) {
                    arrStockList[n] = arr[i]; arrStockList[n].quantity =
                            Product.getQuantityProduct(arr,arrStockList[n].name);
                }
        }
        return arrStockList = optStockList(arrStockList);}


    // метод для удаления пустых индексов из массива типа Product
    private static Product[] optStockList(Product[] product){
        int counter =0;
        for (int i = 0; i <product.length ; i++) {
            if(product[i]==null){counter++;}
        } Product [] tempArr = new Product[product.length-counter];
        System.arraycopy(product,0,tempArr,0,tempArr.length);
        product = new Product[tempArr.length];
         System.arraycopy(tempArr,0,product,0,tempArr.length);
       return product;
    }
}
