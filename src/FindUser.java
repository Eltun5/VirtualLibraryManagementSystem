import java.util.List;
import java.util.Scanner;

public class FindUser {
    static User findName(List<User> arrUser){
        Scanner sr = new Scanner(System.in);
        do {
            System.out.print("Please enter name:");
            String name = sr.nextLine();
            for (User u : arrUser) {
                if (u.getName().equals(name)) {
                    return u;
                }
            }
            try {
                throw new UserNotFoundException(name+" name cannot find.");
            }catch (UserNotFoundException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
    static User findID(List<User> arrUser){
        Scanner sr = new Scanner(System.in);
        do {
            System.out.print("Please enter Id:");
            int Id = sr.nextInt();
            for (User u : arrUser) {
                if (u.getUserID()==Id) {
                    return u;
                }
            }
            try {
                throw new UserNotFoundException(Id+" Id cannot find.");
            }catch (UserNotFoundException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
}
