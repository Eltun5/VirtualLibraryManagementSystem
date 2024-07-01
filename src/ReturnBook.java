import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReturnBook {
    static void returnBook(User selectedAccount, List<Transaction> arrTransaction){
        if (selectedAccount.getBookNum()==0){
            System.out.println("You dont have any book.");
        }else {
            for (Book b : selectedAccount.getBooks())
                if (b != null)
                    System.out.println(b);
            Scanner sr=new Scanner(System.in);
            System.out.print("Please enter book title:");
            String title=sr.nextLine();
            for (int i = 0; i < 3; i++) {
                if (selectedAccount.getBooks()[i]!=null&&selectedAccount.getBooks()[i].getTitle().equalsIgnoreCase(title)) {
                    Book b=selectedAccount.getBooks()[i];
                    selectedAccount.setBookNum(selectedAccount.getBookNum() - 1);
                    b.setAvailable(true);
                    Transaction t1=FindTransaction.findTransactionLateReturnWithName(arrTransaction,selectedAccount,b);
                    if (t1.getMustReturnDate().isBefore(LocalDate.now())){
                        selectedAccount.setLateFees(selectedAccount.getLateFees()+(t1.getMustReturnDate().getDayOfYear()-LocalDate.now().getDayOfYear())*2);
                    }
                    for (Transaction t:arrTransaction){
                        if (selectedAccount.getUserID()==t.getUserID()&&selectedAccount.getBooks()[i].getBookID()==t.getBookID()){
                            t.Return(LocalDate.now());
                            break;
                        }
                    }
                    System.out.println("Book is returned.");
                    if (!b.getReservationList().isEmpty()){
                        BorrowBook.borrowBookWithName(b,arrTransaction);
                    }
                    selectedAccount.setBooks(i,null);
                    break;
                }else {
                    returnBook(selectedAccount,arrTransaction);
                }
            }
        }
    }
}
