package Market;

import java.util.Arrays;

/**
 *
 */
public class ArrayList {

    private int volume =10;// вместимость склада
    private int num = volume;// счётких пустых ячеек в аррайлисте
    Product [] stock ;// массив - склад
    Object [] objects; // поле - массив для остальных элементов


    public ArrayList() {
             stock= new Product[volume];
    }

    public ArrayList (int volume){
        this.volume = volume;
        objects = new Object[volume];
    }


    public void add(Object object){
        for (int i = 0; i <objects.length ; i++) {
            if(i==objects.length){makeBigger(objects);}
        if(objects[i] == null){objects[i]=object;}
        else{if(objects[i] != null){
            objects[i++]=object;i++;}
           else makeBigger(objects);}}
    }

    // метод добавления продуктов в свободные места массива
    public void add(Product object, int quantity){
         // new Product(quantity); // записываем интовое значение в поле quantity объекта Product
          if(quantity >= stock.length){
              makeBigger();}
        for (int j = 0; j < quantity ; j++) {
           if (stock[j]!= null){ quantity++;}
            else {stock[j] = object; num--;
           if(num==0){
               makeBigger();}
           }
        }
    }


        // метод вывода на кансоль объекта типа массив
        public void print(Object[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }}
        // метод проверки свободных мест в массиве
        public void checkFreeSpace (Object[] object){ num=0;
            for (int j = 0; j <object.length ; j++) {
                if(object[j] == null){num++;}
            }
        }

        // метод динамического увеличения массива на треть
        private void makeBigger() {
            this.volume = volume + volume / 3;
            Object[] tempArr = new Object[volume];
            System.arraycopy(stock, 0, tempArr, 0, stock.length);
            this.stock = new Product[volume];
            System.arraycopy(tempArr, 0, stock, 0, stock.length);
            checkFreeSpace(this.stock);
        }

    private void makeBigger(Object [] o) {
        this.volume = volume +volume/3;
        Object[] tempArr = new Object[volume];
        System.arraycopy(o, 0, tempArr, 0, o.length);
        this.stock = new Product[volume];
        System.arraycopy(tempArr, 0, o, 0, o.length);

    }

}
