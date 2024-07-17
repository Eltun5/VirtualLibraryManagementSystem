import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AddBook {
    static Scanner sr1 = new Scanner(System.in);
    static Scanner sr = new Scanner(System.in);
    static Input<Integer> dateInputFunction = s -> {
        System.out.print("Please enter "+s+"(int):");
        return sr1.nextInt();
    };
    static Input<String> nameInputFunction = s -> {
        System.out.print("Please enter "+s+" name:");
        return sr.nextLine();
    };
    static void addBook(List<Book> arrBook) {
        String title;
        do {
            System.out.print("Please enter title:");
            title = sr.nextLine();
            for (Book b : arrBook) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(title + " already exist.");
                    title = null;
                }
            }
        } while (title == null);
        String author= nameInputFunction.input("Author");
        BookGenre bookGenre;
        do {
            System.out.print("""
                    Please enter book genre
                    1.FICTION
                    2.NONFICTION
                    3.SCIENCE
                    4.ART
                    5.PSYCHOLOGICAL
                    Enter(int):""");
            bookGenre = switch (sr1.nextInt()) {
                case 1 -> BookGenre.FICTION;
                case 2 -> BookGenre.NONFICTION;
                case 3 -> BookGenre.SCIENCE;
                case 4 -> BookGenre.ART;
                case 5 -> BookGenre.PSYCHOLOGICAL;
                default -> {
                    System.out.println("Please enter valid int.");
                    yield null;
                }
            };
        } while (bookGenre == null);
        int year = dateInputFunction.input("year");
        int month = dateInputFunction.input("month");
        int day = dateInputFunction.input("day");
        Book book = null;
        try {
            book= new Book(title, author, bookGenre, LocalDate.of(year, month, day));
        }catch (DateTimeException e){
            System.out.println(e.getMessage());
        }
        arrBook.add(book);
    }
}