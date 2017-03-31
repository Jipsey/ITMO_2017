package Task6_Objects.Library_new;

/**
 *
 */
public class Library {
    public int numB ;          // счётчик количества книг
    private int maxB = 10;      // максимальное поличество книг
    Book[] arrLib = new Book[maxB]; // собственна сама библиотека в виде массива типа Book


    void put(Book book,int quantity ) {

        for (int i = 0; i <quantity ; i++) {
            if (numB == arrLib.length){
                System.out.println("Столько книг в библиотеку не поместится!");
            break;
            }
            if (arrLib[i]!= null){quantity++;} //добавляем условие для того чтобы книги не переписывались поверх уже занесенных
            else if (arrLib[i]== null){
            arrLib[i] = book ; numB++;}
        }
    }

    void get(Book book, int quantity){
        for (int i = 0; i < arrLib.length; ) {

                if ( quantity<=0 ){break;}
                if (arrLib[i].equals(book)){
                    arrLib[i] = null; i++; quantity--; numB--;
                    if (i==arrLib.length){break;}}

                    else {i++;}

        }

    }

    public int search(Book book){ // поиск с использованием hashCode
        int counter=0;
        for (int i = 0; i <arrLib.length ; i++) {
            if ( arrLib[i].hashCode() == (book.hashCode())){
                counter++;
            }
        } return counter;

    }
    public void print() {
        for (int i = 0; i <arrLib.length ; i++) {

        System.out.println(arrLib[i]);
    }}
}
