import java.util.List;
import java.util.Scanner;

public class Display {
    static void displayAll(List<User> arr, List<Book> arrBook, List<Transaction> arrTransaction) {
        Scanner sr = new Scanner(System.in);
        System.out.print("""
                                
                                           Display
                 
                1.Display all accounts
                2.Display user with name
                3.Display user with ID
                4.Display all books
                5.Display all books with author
                6.Display all books with genre
                7.Display all borrowing
                8.Display all transactions
                9.Display all transactions with userID
                10.Display all late transaction
                0.back(any int!=1,2,3,4,5,6,7,8,9,10)
                Enter(int):""");
        switch (sr.nextInt()) {
            case 1 -> {
                for (User u : arr) System.out.println(u);
            }
            case 2 -> System.out.println(FindUser.findName(arr));
            case 3 -> System.out.println(FindUser.findID(arr));
            case 4 -> {
                for (Book b : arrBook) System.out.println(b);
            }
            case 5 -> FindBook.findBookAuthor(arrBook);
            case 6 -> FindBook.findBookGenre(arrBook);
            case 7 -> {
                boolean has=false;
                for (User u : arr) {
                    if (u.getBookNum() != 0) {
                        System.out.println(u.getName() + " borrows " + u.getBookNum() + ".");
                        for (Book b : u.getBooks()) {
                            if (b != null) {
                                System.out.println(b.getTitle());
                                has=true;
                            }
                        }
                    }
                }
                if (!has){
                    System.out.println("Has not any borrowing.");
                }
            }
            case 8 -> {
                boolean has=false;
                for (Transaction t : arrTransaction) {
                    System.out.println(t);
                    has=true;
                }
                if (!has){
                    System.out.println("Has not any transaction.");
                }
            }
            case 9 -> FindTransaction.findTransaction(arrTransaction);
            case 10 -> FindTransaction.findTransactionLateReturn(arrTransaction);
            default -> {
            }
        }
    }

    static void displayBooks(List<Book> arrBook, User selectedAccount) {
        Scanner sr = new Scanner(System.in);
        boolean empty = true;
        System.out.print("""
                                
                                           Display
                 
                1.Display all books
                2.Display all books with author
                3.Display all books with genre
                4.Display your fav
                0.back(any int!=1,2,3)
                Enter(int):""");
        switch (sr.nextInt()) {
            case 1 -> {
                for (Book b : arrBook) System.out.println(b);
            }
            case 2 -> FindBook.findBookAuthor(arrBook);
            case 3 -> FindBook.findBookGenre(arrBook);
            case 4 -> System.out.println(selectedAccount.getFav());
            default -> empty = false;
        }
        if (empty) {
            System.out.print("Do you want to add favorites any book.(0 is yes):");
            if (sr.nextInt() == 0) {
                Book b=FindBook.findBookName(arrBook);
                for (Book b1: selectedAccount.getFav()){
                    if (b1==b){
                        System.out.println("This book has your favorites.");
                        return;
                    }
                }
                selectedAccount.setFav(b);
                System.out.println("Addition is successfully");
            }
        }
    }
}
