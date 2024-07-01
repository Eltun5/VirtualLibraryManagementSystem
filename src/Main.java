import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int librarianPIN = 5555;
        System.out.println("Librarian pin is " + librarianPIN + ".");
        User u1 = new User("Eltun", "(+994) 70-777-77-77", "Azerbaijan-Baku",
                "Eltun@gmail.com", "123", UserRole.MEMBER);
        User u2 = new User("Eltun5", "(+994) 70-777-77-77", "Azerbaijan-Baku",
                "Eltun5@gmail.com", "321", UserRole.LIBRARIAN);
        Book b1 = new Book("1984", "Corc Oruell", BookGenre.FICTION,
                LocalDate.of(1949, 6, 8));
        Book b2 = new Book("Devils", "Fyodor Dostoyevsky", BookGenre.PSYCHOLOGICAL,
                LocalDate.of(1872, 5, 1));
        List<User> arrUser = new ArrayList<>();
        List<Book> arrBook = new ArrayList<>();
        List<Transaction> arrTransaction =new ArrayList<>();
        arrUser.add(u1);
        arrUser.add(u2);
        arrBook.add(b1);
        arrBook.add(b2);
        System.out.println(b1+"\n"+b2+"\n"+u1 + "\n" + u2 + "\n\n");
        User selectedUser;
        System.out.println("                Welcome Library");
        arrUser.remove(null);
        selectedUser = Login.login(arrUser);
        do {
            if (selectedUser.getUserRole() == UserRole.LIBRARIAN) {
                selectedUser=ChooseOperations.chooseOperationForLibrarian(arrUser, selectedUser, librarianPIN, arrBook,arrTransaction);
            } else {
                selectedUser=ChooseOperations.chooseOperationForMember(arrUser, selectedUser, arrBook,arrTransaction);
            }
        }while (selectedUser!=null);
    }
}