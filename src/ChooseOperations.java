import java.util.List;
import java.util.Scanner;

public class ChooseOperations {
    static Scanner sr = new Scanner(System.in);
    static Exit exit=()->{
        System.out.print("\n\nDo you really want to exit?(0 yes):");
        if (sr.nextInt() == 0) {
            System.exit(0);
        }
    };
    static User chooseOperationForLibrarian(List<User> arr, User selectedUser,
                                            int librarianPIN, List<Book> arrBook, List<Transaction> arrTransaction) {
        System.out.print("""
                                
                                           Choose Operation
                                
                1.Manage accounts
                2.Manage books
                3.Display
                0.exit
                Enter(int):""");
        switch (sr.nextInt()) {
            case 1 -> selectedUser = ManageInfo.manageAccount(arr, selectedUser, librarianPIN);
            case 2 -> ManageInfo.manageBooks(arrBook);
            case 3 -> Display.displayAll(arr, arrBook, arrTransaction);
            case 0 -> exit.exit();
            default -> System.out.println("Please enter valid number.");
        }
        return selectedUser;
    }

    static User chooseOperationForMember(List<User> arr, User selectedUser, List<Book> arrBook, List<Transaction> arrTransaction) {
        Scanner sr = new Scanner(System.in);
        System.out.print("""
                                
                                           Choose Operation
                                
                1.Change account
                2.Borrow book
                3.Return book
                4.Display books
                5.Pay fees
                0.Exit
                Enter(int):""");
        switch (sr.nextInt()) {
            case 1 -> selectedUser = Login.login(arr);
            case 2 -> BorrowBook.borrowBook(selectedUser, arrBook, arrTransaction);
            case 3 -> ReturnBook.returnBook(selectedUser, arrTransaction);
            case 4 -> Display.displayBooks(arrBook, selectedUser);
            case 5 -> pay(selectedUser);
            case 0 -> exit.exit();
            default -> System.out.println("Please enter valid number.");
        }
        return selectedUser;
    }

    static void pay(User selectedAccount) {
        int i;
        do {
            Scanner sr = new Scanner(System.in);
            System.out.print("Please enter how much you want to pay:");
            i = sr.nextInt();
            if (i <= 0) System.out.println("Please enter valid int:");
        } while (i <= 0);
        selectedAccount.setLateFees(selectedAccount.getLateFees()+i);
        System.out.println("Payment is successfully you have "+selectedAccount.getLateFees()+" fees.");
    }
}
