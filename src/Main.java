//public class Main {
    void main() {
        final String _USERNAME = "jafdel";
        final String _PASSWORD = "P455w0rd";
        Scanner reader = new Scanner(System.in);
        String username = "";
        String password = "";
        byte attempts = 3;
        do {
            IO.print("Enter your username: ");
            username = reader.nextLine();
            IO.print("Enter your password: ");
            password = reader.nextLine();
            if (username.equals(_USERNAME) && password.equals(_PASSWORD)) {
                attempts = -1;
                IO.println("Welcome to the club!");
            } else if (!username.isEmpty() && !username.isBlank() && !password.isEmpty() && !password.isBlank()) {
                IO.println("Nope!");
                attempts--;
                if (attempts > 0)
                    IO.println("You have " + attempts + " more attempt(s).");
                else
                    IO.println("You have been locked out.");
            } else
                IO.println("Please ensure neither the username nor password fields are blank.");
        } while(attempts > 0);
    }
//}
