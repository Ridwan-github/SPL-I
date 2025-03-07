package UI;

import Code.Donor;
import Code.PasswordMasking;
import Code.Recipient;

import java.util.Scanner;

public class HomePage {
    private static String getInput(Scanner scanner) {
        String input = scanner.nextLine();
        if ("0".equals(input)) {
            RedirectClass.redirectMethod();
            System.exit(0);
        }
        return input;
    }

    private static int getIntInput(Scanner scanner) {
        int input = scanner.nextInt();
        if (input == 0) {
            RedirectClass.redirectMethod();
            System.exit(0);
        }
        return input;
    }

    public class RedirectClass {
        public static void redirectMethod() {
            ConsoleUtils consoleUtils = new ConsoleUtils();
            consoleUtils.clearScreen();
            HomePage.main(new String[0]);
        }
    }

    public static void main(String[] args) {
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        PasswordMasking passwordMasking = new PasswordMasking();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================================================================");
        System.out.println(RED + "\t\t\t\t  ____    _                       _               _       _ ");
        System.out.println("\t\t\t\t |  _ \\  | |                     | |      /\\     (_)     | |");
        System.out.println("\t\t\t\t | |_) | | |   ___     ___     __| |     /  \\     _    __| |");
        System.out.println("\t\t\t\t |  _ <  | |  / _ \\   / _ \\   / _` |    / /\\ \\   | |  / _` |");
        System.out.println("\t\t\t\t | |_) | | | | (_) | | (_) | | (_| |   / ____ \\  | | | (_| |");
        System.out.println("\t\t\t\t |____/  |_|  \\___/   \\___/   \\__,_|  /_/    \\_\\ |_|  \\__,_|" + RESET);
        System.out.println("==============================================================================================");

        System.out.println("\nPlease choose an option:");
        System.out.println(RED + "[1]" + RESET + " Login");
        System.out.println(RED + "[2]" + RESET + " Signup");
        System.out.println(RED + "[3]" + RESET + " Exit");
        System.out.println("==============================================================================================");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Invalid choice. Please select 1, 2, or 3.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        switch (choice) {
            case 1:
                consoleUtils.clearScreen();
                System.out.println("==============================================================================================");
                System.out.println(RED + "                      Login" + RESET);
                System.out.println("==============================================================================================");
                System.out.println(RED + "[1]" + RESET + " Donor");
                System.out.println(RED + "[2]" + RESET + " Recipient");
                System.out.println(RED + "[3]" + RESET + " Back");
                System.out.println("==============================================================================================");
                System.out.print("Enter your choice: ");
                int userTypeLogin = scanner.nextInt();
                scanner.nextLine();

                while (userTypeLogin != 1 && userTypeLogin != 2 && userTypeLogin != 3) {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    System.out.print("Enter your choice: ");
                    userTypeLogin = scanner.nextInt();
                    scanner.nextLine();
                }

                switch (userTypeLogin) {
                    case 1:
                        handleDonorLogin(scanner, args);
                        break;

                    case 2:
                        handleRecipientLogin(scanner, args);
                        break;

                    case 3:
                        consoleUtils.clearScreen();
                        main(args);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1 or 2.");
                }
                break;

            case 2:
                consoleUtils.clearScreen();
                System.out.println("==============================================================================================");
                System.out.println(RED + "                      Signup" + RESET);
                System.out.println("==============================================================================================");
                System.out.println(RED + "[1]" + RESET + " Donor");
                System.out.println(RED + "[2]" + RESET + " Recipient");
                System.out.println(RED + "[3]" + RESET + " Back");
                System.out.println("==============================================================================================");
                System.out.print("Enter your choice: ");
                int userType = scanner.nextInt();
                while (userType != 1 && userType != 2 && userType != 3) {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    System.out.print("Enter your choice: ");
                    userType = scanner.nextInt();
                }
                scanner.nextLine();

                switch (userType) {
                    case 1:
                        consoleUtils.clearScreen();
                        DonorSignup_UI.main(args);
                        break;
                    case 2:
                        consoleUtils.clearScreen();
                        RecipientSignup_UI.main(args);
                        break;
                    case 3:
                        consoleUtils.clearScreen();
                        main(args);
                    default:
                        System.out.println("Invalid choice. Please select 1 or 2.");
                }
                break;

            case 3:
                consoleUtils.clearScreen();
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }

        scanner.close();
    }
    private static void handleDonorLogin(Scanner scanner, String[] args) {
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        System.out.println("==============================================================================================");
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        System.out.println(RED + "Donor Login" + RESET);
        System.out.println("==============================================================================================");
        System.out.println("Enter your phone number and password to login. (Enter " + RED + "[0]" + RESET + " to go back)");
        System.out.printf("Phone Number: ");
        String phoneNumber = getInput(scanner);
        if (phoneNumber.equals("0")) {
            consoleUtils.clearScreen();
            main(args);
        }
        System.out.printf("Password: ");
        String password = getInput(scanner);
        if (password.equals("0")) {
            consoleUtils.clearScreen();
            main(args);
        }
        Donor donor = new Donor();
        donor.loginDonor(phoneNumber, password);
        if (donor.getName() != null) {
            consoleUtils.clearScreen();
            Donor_UI.main(phoneNumber, password, args);
        } else {
            System.out.println("Invalid phone number or password.");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            handleDonorLogin(scanner, args);
        }
    }

    private static void handleRecipientLogin(Scanner scanner, String[] args){
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.clearScreen();
        System.out.println("==============================================================================================");
        final String RED = "\033[31m";
        final String RESET = "\033[0m";
        System.out.println(RED + "Recipient Login" + RESET);
        System.out.println("==============================================================================================");
        System.out.println("Enter your phone number and password to login. (Enter " + RED + "[0]" + RESET + " to go back)");
        System.out.print("Enter your phone number: ");
        String phoneNumber = getInput(scanner);
        System.out.print("Enter your password: ");
        String password = getInput(scanner);
        Recipient recipient = new Recipient();
        recipient.loginRecipient(phoneNumber, password);
        if (recipient.getName() != null) {
            consoleUtils.clearScreen();
            Recipient_UI.main(phoneNumber, password, args);
        } else {
            System.out.println("Invalid phone number or password.");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            handleRecipientLogin(scanner, args);
        }
    }
}