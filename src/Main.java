//import com.loginchallenge.models.User;
import com.loginchallenge.models.UserList;

//public class Main {
    void main() {
        Path file = Path.of("users.txt");
        UserList userList = new UserList(file);

        Scanner reader = new Scanner(System.in);
        byte attempts = 3;
        do {
            IO.print("Enter your username: ");
            String username = reader.nextLine();
            IO.print("Enter your password: ");
            String password = reader.nextLine();
            if (isValid(username, password)) {
                if (userList.isMatch(username, password)) {
                    attempts = -1;
                    IO.println("Welcome to the club!");
                } else {
                    IO.println("Nope!");
                    if (--attempts > 0) // attempts == 1 means last attempt
                        IO.println("You have " + attempts + " more attempt(s).");
                    else
                        IO.println("You have been locked out.");
                }
            } else
                IO.println("Please ensure neither the username nor password fields are blank.");
        } while(attempts > 0);
    }

    boolean isValid(String username, String password) {
        return (!username.isBlank() && !password.isBlank());
    }
//}
