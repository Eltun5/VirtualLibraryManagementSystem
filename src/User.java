import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final int userID;
    private static int counterID=0;
    private String name,phone,address,email,password;
    private final Book[] books=new Book[3];
    private UserRole userRole;
    private int bookNum=0;
    private final List<Book> fav=new ArrayList<>();
    private int lateFees=0;
    public int getLateFees() {
        return lateFees;
    }
    public void setLateFees(int lateFees) {
        this.lateFees = lateFees;
    }
    public List<Book> getFav() {
        return fav;
    }
    public void setFav(Book book) {
        this.fav.add(book);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public Book[] getBooks() {
        return books;
    }
    public void setBooks(int i,Book book){
        books[i]=book;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public User(String name, String phone, String address, String email, String password, UserRole userRole) {
        this.userID= ++counterID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
               "userID=" + userID +
               ", name='" + name + '\'' +
               ", phone='" + phone + '\'' +
               ", address='" + address + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", books=" + Arrays.toString(books) +
               ", userRole=" + userRole +
               ", bookNum=" + bookNum +
               ", fav=" + fav +
               ", lateFees=" + lateFees +
               '}';
    }
}