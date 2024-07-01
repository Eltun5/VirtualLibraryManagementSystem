import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FindTransaction {
    static void findTransaction(List<Transaction> arrTransaction){
        Scanner sr=new Scanner(System.in);
        System.out.print("Please enter Id:");
        int i= sr.nextInt();
        boolean has=false;
        for (Transaction t:arrTransaction){
            if (t.getUserID()==i){
                has= true;
                System.out.println(t);
            }
        }
        if (!has){
            System.out.println(i+" this id has not transaction.");
        }
    }
    static void findTransactionLateReturn(List<Transaction> arrTransaction){
        boolean has=false;
        for (Transaction t:arrTransaction){
            if (t.getMustReturnDate().isBefore(LocalDate.now())){
                has= true;
                System.out.println(t);
            }
        }
        if (!has){
            System.out.println("There is no late transaction.");
        }
    }
    static Transaction findTransactionLateReturnWithName(List<Transaction> arrTransaction,User selectedUser,Book b){
        for (Transaction t:arrTransaction){
            if (t.getUserID()== selectedUser.getUserID()&&t.getTransactionType()==TransactionType.BORROW&&t.getBookID()==b.getBookID()){
                return t;
            }
        }
        return null;
    }
}
