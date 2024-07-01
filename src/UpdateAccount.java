import java.util.List;
import java.util.Scanner;

public class UpdateAccount {
    public static void updateAccount(List<User> arr,User user,int librarianPIN){
        if(user!=null) {
            Scanner sr = new Scanner(System.in);
            Scanner sr1 = new Scanner(System.in);
            System.out.println(user);
            System.out.print("""
                                    
                    1.name
                    2.phone
                    3.address
                    4.email
                    5.password
                    6.userRole
                    0.back
                    Enter(int):""");
            switch (sr1.nextInt()) {
                case 1 -> {
                    String name;
                    do {
                        System.out.print("Please enter name without @ and length must be grater than 3:");
                        name = sr.nextLine();
                        for (User u : arr) {
                            if (u.getName().equals(name)) {
                                name = "";
                                System.out.println("This name already exist.");
                            }
                        }
                    } while (name.length() < 3 || name.contains("@"));
                    user.setName(name);
                }
                case 2 -> {
                    String phone;
                    do {
                        System.out.print("Please enter phone number use only 0-9,+,- and () " +
                                         "for example (+102)345-67-89 :");
                        phone = sr.nextLine();
                        for (int i = 0; i < phone.length(); i++) {
                            char c = phone.charAt(i);
                            if (c != 40 && c != 41 && c != 43 && c != 45 && !(c > 47 && c < 58)) {
                                System.out.println("Please enter valid phone number.");
                                phone = "";
                            }
                        }
                    } while (phone.isEmpty());
                    user.setPhone(phone);
                }
                case 3 -> {
                    System.out.print("Please enter address:");
                    user.setAddress(sr.nextLine());
                }
                case 4 -> {
                    String email;
                    do {
                        System.out.print("Please enter email must be include @:");
                        email = sr.nextLine();
                        for (User u : arr) {
                            if (u.getEmail().equals(email)) {
                                email = "";
                                System.out.println("This email already exist.");
                            }
                        }
                    } while (!email.contains("@"));
                    user.setEmail(email);
                }
                case 5 -> {
                    String password;
                    do {
                        System.out.print("Please enter password must be grater than 8 character:");
                        password = sr.nextLine();
                    } while (password.length() < 8);
                    user.setPassword(password);
                }
                case 6 -> {
                    System.out.print("Are you a Librarian?(0 is yes):");
                    if (sr1.nextInt() == 0) {
                        do {
                            System.out.print("Please enter Librarian Pin:");
                        } while (sr1.nextInt() != librarianPIN);
                        user.setUserRole(UserRole.LIBRARIAN);
                    } else {
                        user.setUserRole(UserRole.MEMBER);
                    }
                }
                case 0 -> {
                }
                default -> {
                    System.out.println("Please enter valid int.");
                    updateAccount(arr, user, librarianPIN);
                }
            }
        }
    }
}