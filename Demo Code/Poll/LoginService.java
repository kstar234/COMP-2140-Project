import java.util.Scanner;

public class LoginService {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";
    private static final String STUDENT_USERNAME = "student";
    private static final String STUDENT_PASSWORD = "uwimona";

    public static User loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user type (admin/student): ");
        String userType = scanner.nextLine().toLowerCase();

        switch (userType) {
            case "admin":
                return loginAdmin();
            case "student":
                return loginStudent();
            default:
                System.out.println("Invalid user type. Please try again.\n");
                return null;
        }
    }

    private static User loginAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();

        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Admin login successful!\n");
            return new User(username, password, UserType.ADMIN);
        } else {
            System.out.println("Invalid admin username or password. Please try again.\n");
            return null;
        }
    }

    private static User loginStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student username: ");
        String username = scanner.nextLine();

        System.out.print("Enter student password: ");
        String password = scanner.nextLine();

        if (username.equals(STUDENT_USERNAME) && password.equals(STUDENT_PASSWORD)) {
            System.out.println("Student login successful!\n");
            return new User(username, password, UserType.STUDENT);
        } else {
            System.out.println("Invalid student username or password. Please try again.\n");
            return null;
        }
    }
}
