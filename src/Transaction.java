import java.time.LocalDate;

public class Transaction {
     private final int transactionID;
     private static int transcriptionCounter=0;
     private final int userID;
    private final int bookID;
     private final LocalDate borrowDate;
    private LocalDate returnDate;
    private final LocalDate mustReturnDate;
     private TransactionType transactionType;

    public LocalDate getMustReturnDate() {
        return mustReturnDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getUserID() {
        return userID;
    }

    public int getBookID() {
        return bookID;
    }

    public Transaction(int userID, int bookID, LocalDate borrowDate) {
        this.transactionID= ++transcriptionCounter;
        this.userID = userID;
        this.bookID = bookID;
        this.borrowDate = borrowDate;
        this.mustReturnDate=borrowDate.plusDays(7);
        this.transactionType = TransactionType.BORROW;
    }
    public void Return(LocalDate returnDate){
        this.returnDate=returnDate;
        this.transactionType = TransactionType.RETURN;
    }

    @Override
    public String toString() {
        return "Transaction{" +
               "transactionID=" + transactionID +
               ", userID=" + userID +
               ", bookID=" + bookID +
               ", borrowDate=" + borrowDate +
               ", returnDate=" + returnDate +
               ", mustReturnDate=" + mustReturnDate +
               ", transactionType=" + transactionType +
               '}';
    }
}
