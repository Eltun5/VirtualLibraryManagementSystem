import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class FindBook {
    static Function<List<Book>, Book> FindBookFunction = (arrBook) -> {
        Scanner sr = new Scanner(System.in);
        Book book = null;
        do {
            System.out.print("Please enter title of book:");
            String title = sr.nextLine();
            for (Book b : arrBook) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    book = b;
                    break;
                }
            }
            if (book == null)
                System.out.println("Title is wrong try again.");
        } while (book == null);
        return book;
    };
    static Consumer<List<Book>> FindBookAuthorFunction = arrBook -> {
        Scanner sr = new Scanner(System.in);
        boolean has = false;
        System.out.print("Please enter author of book:");
        String author = sr.nextLine();
        for (Book b : arrBook) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                has = true;
            }
        }
        if (!has) {
            System.out.println("Has not any book that author name is " + author);
        }
    };


    static void findBookGenre(List<Book> arrBook) {
        Scanner sr = new Scanner(System.in);
        boolean has = false;
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
            bookGenre = switch (sr.nextInt()) {
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
        for (Book b : arrBook) {
            if (b.getGenre() == bookGenre) {
                System.out.println(b);
                has = true;
            }
        }
        if (!has) {
            System.out.println("Has not any book that genre is " + bookGenre);
        }
    }
}