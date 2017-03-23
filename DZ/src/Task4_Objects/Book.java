/**
 *
 */
package Task4_Objects;

public class Book {

    public String  author;
    public String  title;
    public int     pagesNum;

    public Book (){

    }

    public Book(String author, String title, int pagesNum){
          this.author = author;
          this.title = title;
          this.pagesNum = pagesNum;
    }

    @Override
    public String toString() {
        return "Book:" + author +'\t' + title + '\t' + pagesNum + "pgs";
    }
}
