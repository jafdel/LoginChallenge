//public class Main {
    void main() {
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> credentials = new ArrayList<>();
        users.add("jafdel");
        credentials.add("password");
        users.add("thefuzzbuzz");
        credentials.add("Password");
        users.add("bcocozza");
        credentials.add("P455w0rd");

        Scanner reader = new Scanner(System.in);
        byte attempts = 3;
        do {
            IO.print("Enter your username: ");
            String username = reader.nextLine();
            IO.print("Enter your password: ");
            String password = reader.nextLine();
            if (isValid(username, password)) {
                if (isMatch(username, password, users, credentials)) {
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

    boolean isMatch(String username, String password, ArrayList<String> users, ArrayList<String> credentials) {
        for (int i=0; i<users.size(); i++) {
            if (username.equals(users.get(i)) && password.equals(credentials.get(i)))
                return true;
        }
        return false;
    }

    boolean isValid(String username, String password) {
        return (!username.isEmpty() && !username.isBlank() && !password.isEmpty() && !password.isBlank());
    }
//}
