package Task6_Objects.Library_new;

/**
 *
 */
public class Book {
    private String author;
    private String title;
    private int numPgs;

    public Book(String author, String title, int numPgs){
        this.author = author;
        this.title = title;
        this.numPgs = numPgs;
    }

    @Override
    public String toString() {
        return "book: " + author +'\t' + title + '\t' + numPgs +  "pgs";

    }
}
