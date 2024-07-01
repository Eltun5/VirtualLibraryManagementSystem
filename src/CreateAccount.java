import java.util.List;
import java.util.Scanner;

public class CreateAccount {
    public static void createAccount(List<User> arr,int librarianPIN){
        Scanner sr=new Scanner(System.in);
        Scanner sr1 =new Scanner(System.in);
        String name;
        do {
            System.out.print("Please enter name without @ and length must be grater than 3:");
            name =sr.nextLine();
            for (User u:arr){
                if (u.getName().equals(name)){
                    name="";
                    System.out.println("This name already exist.");
                }
            }
        }while (name.length()<3||name.contains("@"));
        String phone;
        do {
            System.out.print("Please enter phone number use only 0-9,+,- and () " +
                             "for example (+102)345-67-89 :");
            phone =sr.nextLine();
            for (int i = 0; i < phone.length(); i++) {
                char c=phone.charAt(i);
                if(c!=40&&c!=41&&c!=43&&c!=45&&!(c>47&&c<58)){
                    System.out.println("Please enter valid phone number.");
                    phone="";
                }
            }
        }while (phone.isEmpty());
        System.out.print("Please enter address:");
        String address=sr.nextLine();
        String email;
        do {
            System.out.print("Please enter email must be include @:");
            email =sr.nextLine();
            for (User u:arr){
                if (u.getEmail().equals(email)){
                    email="";
                    System.out.println("This email already exist.");
                }
            }
        }while (!email.contains("@"));
        String password;
        do {
            System.out.print("Please enter password must be grater than 8 character:");
            password =sr.nextLine();
        }while (password.length()<8);
        System.out.print("Are you a Librarian?(0 is yes):");
        User user;
        if (sr1.nextInt() == 0) {
            do {
                System.out.print("Please enter Librarian Pin:");
            } while (sr1.nextInt() != librarianPIN);
            user = new User(name, phone, address, email, password, UserRole.LIBRARIAN);
        } else {
            user = new User(name, phone, address, email, password, UserRole.MEMBER);
        }
        arr.add(user);
    }
}
