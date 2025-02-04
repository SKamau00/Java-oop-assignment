import java.io.Console;
import java.util.Scanner;
public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();

        // These are the hardcoded credentials that are used for validation
        String correctUsername = "admin";
        String correctPassword = "1234";

        //This is the number of attempts that I allow
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine(); // this reads the user input

            // this reads the password securely by encrypting it and printing '*' for every char
            char[] passwordArray;
            if (console != null) {
                passwordArray = console.readPassword("Enter Password: ");
            } else {
                System.out.print("Enter Password: ");
                passwordArray = scanner.nextLine().toCharArray();
            }

            String password = new String(passwordArray);

            // this is to validate all the credentials
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login Successful! Welcome, " + username);
                break; // the loop is exited if the login is successful
            } else {
                attempts--; // this reduces the count on each failure
                System.out.println("Incorrect username or password. Attempts left: " + attempts);
            }

            if (attempts == 0) {
                System.out.println("Too many failed attempts. Access denied.");
            }
        }
        scanner.close();
    }
}


