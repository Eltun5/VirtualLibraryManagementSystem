import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private final int bookID;
    private static int bookCounter=0;
    private String title,author;
    private BookGenre genre;
    private LocalDate publicationDate;
    private boolean isAvailable=true;
    private final List<User> reservationList=new ArrayList<>();

    public List<User> getReservationList() {
        return reservationList;
    }

    public void setReservationListAdd(User reservation) {
        this.reservationList.addFirst(reservation);
    }
    public void setReservationListRemove(User reservation) {
        this.reservationList.remove(reservation);
    }

    public String getAuthor() {
        return author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public int getBookID() {
        return bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public Book(String title, String author, BookGenre genre, LocalDate publicationDate) {
        this.bookID = ++bookCounter;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
               "bookID=" + bookID +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", genre=" + genre +
               ", publicationDate=" + publicationDate +
               ", isAvailable=" + isAvailable +
               '}';
    }
}