import java.util.*;

public class BookComparator implements Comparator<Book> {
    
    public int compare(Book a, Book b){
        if (a.getAuthor().equals(b.getAuthor())) {
            if (a.getTitle().equals(b.getTitle())) {
                return a.getYear()-b.getYear();
            }
            return a.getTitle().compareTo(b.getTitle());
        }
        return a.getAuthor().compareTo(b.getAuthor());
    }
    
}