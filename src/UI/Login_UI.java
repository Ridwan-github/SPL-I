package UI;

import Code.Donor;
import Code.PasswordMasking;
import Code.Recipient;

import java.util.Scanner;

public class Login_UI {

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
                        consoleUtils.clearScreen();
                        System.out.println("==============================================================================================");
                        System.out.println(RED + "Donor Login" + RESET);
                        System.out.println("==============================================================================================");
                        System.out.println("Enter your phone number and password to login.");
                        System.out.printf("Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.printf("Password: ");
                        String password = passwordMasking.getPassword();
                        Donor donor = new Donor();
                        donor.loginDonor(phoneNumber, password);
                        if (donor.getName() != null) {
                            consoleUtils.clearScreen();
                            Donor_UI.main(phoneNumber, password, args);
                        } else {
                            System.out.println("Invalid phone number or password.");
                            System.out.println("Forgot password?");
                            System.out.println(RED + "[1]" + RESET + " Yes");
                            System.out.println(RED + "[2]" + RESET + " Retry");
                            System.out.println("==============================================================================================");
                            System.out.print("Enter your choice: ");
                            int forgotPassword = scanner.nextInt();
                            scanner.nextLine();

                            while (forgotPassword != 1 && forgotPassword != 2) {
                                System.out.println("Invalid choice. Please select 1 or 2.");
                                System.out.print("Enter your choice: ");
                                forgotPassword = scanner.nextInt();
                                scanner.nextLine();
                            }

                            if (forgotPassword == 1) {
                                System.out.println("==============================================================================================");
                                System.out.println("                                    Forgot Password");
                                System.out.println("==============================================================================================");
                                System.out.println("Enter your email: ");
                                String email = scanner.nextLine();
                                System.out.println("Enter your Phone Number: ");
                                String phone = scanner.nextLine();
                                System.out.println("Enter your username: ");
                                String username = scanner.nextLine();

                                ForgotPassword forgotPasswordObj = new ForgotPassword();
                                forgotPasswordObj.forgotDonorPassword(email, phone, username);
                                consoleUtils.holdTime();
                                consoleUtils.clearScreen();
                                Donor_UI.main(phoneNumber, password, args);
                            }
                            consoleUtils.holdTime();
                            consoleUtils.clearScreen();
                            main(args);
                        }
                        break;

                    case 2:
                        consoleUtils.clearScreen();
                        System.out.println("==============================================================================================");
                        System.out.println(RED + "Recipient Login" + RESET);
                        System.out.println("==============================================================================================");
                        System.out.print("Enter your phone number: ");
                        phoneNumber = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        password = passwordMasking.getPassword();
                        Recipient recipient = new Recipient();
                        recipient.loginRecipient(phoneNumber, password);
                        if (recipient.getName() != null) {
                            consoleUtils.clearScreen();
                            Recipient_UI.main(phoneNumber, password, args);
                        } else {
                            System.out.println("Invalid phone number or password.");
                            consoleUtils.holdTime();
                            consoleUtils.clearScreen();
                            main(args);
                        }
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
}
