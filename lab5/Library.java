import java.util.*;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
        library.add(b);
    }

    public void sort() {
       Collections.sort(library, new BookComparator());
    }
    public void printLibrary() {
        for(Book b: library) 
            System.out.println(b);
    }
}