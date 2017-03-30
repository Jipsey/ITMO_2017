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

    @Override
    public int hashCode() {
            int result = title.hashCode();
            result = 31 * result + author.hashCode();
            result = 31 * result + numPgs;
            return result;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (numPgs != book.numPgs) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }
}

