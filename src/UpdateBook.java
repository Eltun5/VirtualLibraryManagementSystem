import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UpdateBook {
    static void updateBook(List<Book> arrBook){
        Book book=FindBook.FindBookFunction.apply(arrBook);
        Scanner sr = new Scanner(System.in);
        Scanner sr1 = new Scanner(System.in);
        System.out.print("""
                1.Title
                2.Author
                3.BookGenre
                4.PublicationDate
                0.Back(any int!=1,2,3,4)
                Enter(int):""");
        switch (sr1.nextInt()){
            case 1->{
                String title ;
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
                book.setTitle(title);
            }
            case 2->{
                System.out.print("Please enter author name:");
                book.setAuthor(sr.nextLine());
            }
            case 3->{
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
                book.setGenre(bookGenre);
            }
            case 4->{
                System.out.print("Please enter year(int):");
                int year = sr1.nextInt();
                System.out.print("Please enter month(int):");
                int month = sr1.nextInt();
                System.out.print("Please enter day(int):");
                int day = sr1.nextInt();
                book.setPublicationDate(LocalDate.of(year, month, day));
            }
            default -> {}
        }
    }
}
