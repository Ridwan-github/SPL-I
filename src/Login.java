import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display the full UI, including placeholders for username and password inputs
            System.out.println("==============================================================================================");
            System.out.println(RED + "  ____  _                 _          _     _ ");
            System.out.println(" |  _ \\| |               | |   /\\   (_)   | |");
            System.out.println(" | |_) | | ___   ___   __| |  /  \\   _  __| |");
            System.out.println(" |  _ <| |/ _ \\ / _ \\ / _` | / /\\ \\ | |/ _` |");
            System.out.println(" | |_) | | (_) | (_) | (_| |/ ____ \\| | (_| |");
            System.out.println(" |____/|_|\\___/ \\___/ \\__,_/_/    \\_\\_|\\__,_|" + RESET);
            System.out.println("==============================================================================================");

            // Display options for the user, already visible in the initial print
            System.out.println("\nPlease choose an option:");
            System.out.println(RED + "[1]" + RESET + " Login");
            System.out.println(RED + "[2]" + RESET + " Signup");
            System.out.println(RED + "[3]" + RESET + " Exit");
            System.out.println("==============================================================================================");

            // Prompt for option input
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from input buffer

            // Handle menu options
            switch (choice) {
                case 1:
                    System.out.printf("Username: ");
                    String username = scanner.nextLine();
                    System.out.printf("Password: ");
                    String password = scanner.nextLine();
                    System.out.println("Logging in ");
                    running = false;

                    Donor.main(args);

                    break;
                case 2:
                    System.out.println("Navigating to signup page...");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }

            System.out.println("==============================================================================================");

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        scanner.close();
    }
}
