package UI;
import Code.ChatSystem;
import Code.Recipient;

import java.util.Scanner;

class Recipient_UI  {

    public static void main(String phone, String password, String[] args) {
        String phoneNumber = phone;
        String pass = password;
        ConsoleUtils consoleUtils = new ConsoleUtils();
        Recipient recipient = new Recipient();
        recipient.loginRecipient(phoneNumber, pass);

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        System.out.println("==========================================================================");
        System.out.println("                          Dashboard");
        System.out.println("==========================================================================");
        System.out.println("                        Welcome," + RED + recipient.getName() + RESET + "!");
        System.out.println("==========================================================================");
        System.out.println(RED + "[1]" + RESET + " Search for donors");
        System.out.println(RED + "[2]" + RESET + " View my requests");
        System.out.println(RED  + "[3]" + RESET + " View blood received history");
        System.out.println(RED + "[4]" + RESET + " Refresh");
        System.out.printf(RED + "[5]" + RESET + " Chat");
        ChatSystem chatSystem = new ChatSystem();
        if (chatSystem.checkChatForRecipient(phoneNumber)){
            System.out.println(RED + " (New)" + RESET);
        } else {
            System.out.println();
        }
        System.out.println(RED + "[6]" + RESET + " Donation Confirmation");
        System.out.println(RED + "[0]" + RESET + " Back");
        System.out.println("==========================================================================");

        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 0) {
            System.out.println("Invalid choice! Please try again.");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        switch (choice) {
            case 1:
                consoleUtils.clearScreen();
                Search_UI.main(recipient.getName(), phone, password, args);
                main(phone, password, args);

            case 2:
                consoleUtils.clearScreen();
                RecipientBloodRequest_UI.main(phone, password, args);
                break;
            case 3:
                consoleUtils.clearScreen();
                ReceivedHistory_UI.main(phone, password, args);
                break;
            case 4:
                consoleUtils.clearScreen();
                main(phone, password, args);
                break;
            case 5:
                consoleUtils.clearScreen();
                Recipient_Chat_UI.main(phone, password, args);
                break;
            case 6:
                consoleUtils.clearScreen();
                Donation_Confirmation_UI.main(phone, password, args);
                break;
            case 0:
                consoleUtils.clearScreen();
                User_UI.main(phone, password, args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }
    }
}