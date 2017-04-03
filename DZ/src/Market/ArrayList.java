package Market;

/**
 *
 */
public class ArrayList {

    public int volume =10;// вместимость склада
    public int num = volume;// счётких пустых ячеек в аррайлисте
    Product [] stock = new Product[volume];// массив - склад

    public ArrayList() {
    }

    // метод добавления продуктов в свободные места массива
    public void add(Product object, int quantity){
          new Product(quantity); // записываем интовое значение в поле quantity объекта Product
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
        this.volume = volume +volume/3;
        Object[] tempArr = new Object[volume];
        System.arraycopy(stock, 0, tempArr, 0, stock.length);
        this.stock = new Product[volume];
        System.arraycopy(tempArr, 0, stock, 0, stock.length);
        checkFreeSpace(this.stock);

    }

    // метод удаления пустых индексов масива данных типа Product

}
