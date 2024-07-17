import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BorrowBook {
    static void borrowBook(User selectedAccount, List<Book> arrBook,List<Transaction> arrTransaction) {
        if (selectedAccount.getBookNum() == 3) {
            System.out.println("You cannot borrow grater than 3 books.");
        } else {
            int empty = 0;
            for (int i = 0; i < 3; i++) {
                if (selectedAccount.getBooks()[i] == null) {
                    empty = i;
                    break;
                }
            }
            Scanner sr1=new Scanner(System.in);
            String title = AddBook.nameInputFunction.input("book");
            boolean has1=false;
            for (Book b : arrBook) {
                if (title.equalsIgnoreCase(b.getTitle())) {
                    if (b.isAvailable()) {
                        selectedAccount.setBooks(empty, b);
                        b.setAvailable(false);
                        selectedAccount.setBookNum(selectedAccount.getBookNum()+1);
                        if (selectedAccount.getBookNum()==1){
                            System.out.println("Borrowing is successfully.You have 1 book.");
                        }else {
                            System.out.println("Borrowing is successfully.You have "+selectedAccount.getBookNum()+" books.");
                        }
                        arrTransaction.add(new Transaction(selectedAccount.getUserID(),b.getBookID(), LocalDate.now()));
                        has1=true;
                        break;
                    } else {
                        for (Book b1:selectedAccount.getBooks()){
                            if (b==b1){
                                System.out.println("You have already this book.");
                                return;
                            }
                        }
                        try {
                            throw new BookNotAvailableException("Book is not available. Please try again later.");
                        }catch (BookNotAvailableException e){
                            System.out.println(e.getMessage());
                        }
                        boolean has=false;
                        for (Book b1:selectedAccount.getBooks()){
                            if(b1==b){
                                has=true;
                                break;
                            }
                        }
                        if (!has) {
                            System.out.print("Do you want to reservation this book?(0 is yes):");
                            if (sr1.nextInt() == 0) {
                                b.setReservationListAdd(selectedAccount);
                                System.out.println("Reservation is successfully.");
                            }
                        }
                        break;
                    }
                }
            }
            if (!has1) System.out.println("This book is not exist please look at books.");
        }
    }
    static void borrowBookWithName(Book b,List<Transaction> arrTransaction){
        User selectedAccount;
        do {
            selectedAccount=b.getReservationList().getLast();
        }while(selectedAccount.getBookNum()==3);
        for (int i = 0; i < 3; i++) {
            if (selectedAccount.getBooks()[i]==null) selectedAccount.setBooks(1,b);
        }
        b.setAvailable(false);
        selectedAccount.setBookNum(selectedAccount.getBookNum()+1);
        b.setReservationListRemove(selectedAccount);
        arrTransaction.add(new Transaction(selectedAccount.getUserID(),b.getBookID(), LocalDate.now()));
        System.out.println("Borrowing is successfully ("+selectedAccount.getName()+" borrow "+b.getTitle()+")");
    }
}
