import java.util.List;
import java.util.Scanner;

public class ManageInfo {
    static User manageAccount(List<User> arr,User selectedUser,int librarianPIN){
        Scanner sr = new Scanner(System.in);
        System.out.print("""
                                
                                           Manage Account
                
                1.Change account
                2.Create account
                3.Update account
                4.Delete account
                0.back(any int!=1,2,3,4)
                Enter(int):""");
        switch (sr.nextInt()) {
            case 1 -> selectedUser = Login.login(arr);
            case 2 -> CreateAccount.createAccount(arr, librarianPIN);
            case 3 -> UpdateAccount.updateAccount(arr, Login.login(arr), librarianPIN);
            case 4 -> arr.remove(Login.login(arr));
            default ->{}
        }
        return selectedUser;
    }
    static void manageBooks(List<Book> arrBook){
        Scanner sr = new Scanner(System.in);
        System.out.print("""
                                
                                           Manage Books
                                
                1.Add book
                2.Remove book
                3.Update book
                0.exit(any int!=1,2,3)
                Enter(int):""");
        switch (sr.nextInt()) {
            case 1 -> AddBook.addBook(arrBook);
            case 2 -> arrBook.remove(FindBook.FindBookFunction.apply(arrBook));
            case 3 -> UpdateBook.updateBook(arrBook);
            default -> {}
        }
    }
}
