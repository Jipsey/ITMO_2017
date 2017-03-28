package Task6_Objects.Library_new;

/**
 * Сделать библиотеку, которая ведет учет книг. Должно быть как минимум два класса: Book и Library.
 * Library имеет два метода: void put(Book book, int quantity) и int get(Book book, int quantity).
 * Каждой книге в библиотеке соответсвует счетчик, показывающий количество хранящихся книг,
 * при добавлении книги - счетчик увеличивается, при извлечении - уменьшается на число quantity.
 * Поля класса Book: author, title, pagesNum.
 */
public class Main {
    public static void main(String[] args) {

        Book kniga1 = new Book("Gosling", "Java", 150);
        Book kniga2 = new Book("Dostaevskiy","Brothers Karomazovy",300);

        Library lib = new Library();

        lib.put(kniga1,3);
        lib.put(kniga2,3);
        lib.put(kniga1,7);
        lib.print();
        System.out.println("***************************");
        lib.get(kniga1,9);
        lib.print();

        System.out.printf("********************\n%s",lib.numB);
    }
}
