/**
 *
 */
package Task4_Objects;


public class MainMethod {
    public static void main(String[] args) {

        Book kniga1 = new Book("Gogol","Taras Bulba",120);
        Book kniga2 = new Book("Pushkin","Onegin",200);
        Book kniga3 = new Book("Dostaevskiy","Prest&Nakazanie",650);

        Library bib = new Library();

        bib.put(kniga1,2);
        bib.put(kniga2,6);
        bib.print( );
        bib.put(kniga3,4);
        bib.print( );
        bib.get(kniga3,2);
        bib.print( );

        System.out.println("Всего книг в библиотеке " + bib.numBook +" штук");
    }


}
