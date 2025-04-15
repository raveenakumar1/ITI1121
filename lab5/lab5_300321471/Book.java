public class Book {

    // Your variables declaration here
  private String author;
  private String title;
  private int year;
  
    public Book (String author, String title, int year) {
        this.author = author;
    this.title = title;
    this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object other) {
    
       return other != null && this.toString().equals(other.toString());
    }

    public String toString() {
        return author+":"+title+"("+year+")";
    }
}