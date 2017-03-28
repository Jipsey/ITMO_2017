/**
 *
 */
package Task4_Objects;
import java.util.Arrays;

public class Library {
    public int numBook = 0 ; // счётчик количества книг
    public int nowBook = 0; // переменная для переопределения количества книг
    private int maxBook =15; // переменная обозначающая максимальное количество книг
    Book [] books = new Book[maxBook]; // представляем библиотеку в ввиде массива тип Book

   public void put (Book book, int qantity){
       if (qantity <= 0){ System.out.println(" Вы вели неверное количество книг ");}
       if (numBook == 0 && numBook < books.length){
             for (int i = 0; i <qantity ; i++) {
                 books[i] = book; numBook++;
             }}
           else {
           nowBook = numBook;
           for (int i = 0; i < qantity; i++) {
               books[i + nowBook] = book;
               numBook++;
               if (numBook==books.length){
                   System.out.println(" Библиотека заполнена полностью !");
                   break;}
           }
       }
   }

    public void get(Book book, int quantity){
        for (int i = 0; i < books.length ; i++) {
            if (quantity == 0) {
                System.out.println(" Введите количество книг больше нуля! ");
                break;}
            if(numBook==0){
                System.out.println(" Библиотека пуста! ");
                break;}

            if (books[i].equals(book) && quantity > 0 ) {
            books[i] = null;
            quantity--;
            numBook--;}
        }

    }

    public void print() {
        for (int i = 0; i <books.length; i++) {
            System.out.println(books[i]);
        }
        System.out.println("************************************");
    }

    }


