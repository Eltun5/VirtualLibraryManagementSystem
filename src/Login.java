import java.util.List;
import java.util.Scanner;

public class Login {
    public static User login(List<User> arr) {
        Scanner sr = new Scanner(System.in);
        User user;
        do {
            System.out.print("\nPlease enter name or email:");
            String s = sr.nextLine();
            user = null;
            if (s.contains("@")) {
                for (User u : arr) {
                    if (u.getEmail().equals(s)) {
                        user = u;
                    }
                }
            } else {
                for (User u : arr) {
                    if (u.getName().equals(s)) {
                        user = u;
                    }
                }
            }
            if (user == null)
                try {
                    throw new UserNotFoundException(s+" name or email cannot find.");
                }catch (UserNotFoundException e){
                    System.out.println(e.getMessage());
                }
        } while (user == null);
        String password;
        do {
            System.out.print("Please enter password:");
            password=sr.nextLine();
            if (!password.equals(user.getPassword()))
                try {
                    throw new UserNotFoundException(password+" password cannot find.");
                }catch (UserNotFoundException e){
                    System.out.println(e.getMessage());
                }
        }while(!password.equals(user.getPassword()));
        return user;
    }
}
