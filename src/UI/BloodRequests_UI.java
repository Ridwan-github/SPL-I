package UI;

import Code.Donor;
import Code.DonationManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BloodRequests_UI {
    public static void main(String phoneNumber, String pass, String[] args) {
        String phone = phoneNumber;
        String password = pass;

        ConsoleUtils consoleUtils = new ConsoleUtils();
        Donor donor = new Donor();
        donor.loginDonor(phoneNumber, password);
        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        String donorID = donor.getDonorID();

        System.out.println("==============================================================================================");
        System.out.println("                                    Blood Donation Requests");
        System.out.println("                                    Blood Group: " + donor.getBloodGroup());
        System.out.println("==============================================================================================");

        File file = new File("DonationRequestHistory.txt");
        List<String[]> matchingRequests = new ArrayList<>();
        int recipientCount = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] requestData = line.split(";");
                if (requestData.length == 4) {
                    String fileDonorID = requestData[0];
                    String recipientName = requestData[1];
                    String recipientPhoneNumber = requestData[2];
                    String status = requestData[3];

                    if (fileDonorID.equals(donorID)) {
                        matchingRequests.add(new String[]{recipientName, recipientPhoneNumber, status});
                        System.out.println(RED + "[" + recipientCount + "]" + RESET +
                                " Recipient Name: " + RED + recipientName + RESET + " | Location: " + RED + "Hospital name, Address" + RESET +
                                " | Contact Number: " + RED + recipientPhoneNumber + RESET + " | Status: " + RED + status + RESET);
                        recipientCount++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the donation request history file.");
            e.printStackTrace();
        }

        if (recipientCount == 1) {
            System.out.println("No donation requests found for this donor.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("==============================================================================================");
        System.out.println("Enter the serial number of the request to accept or 0 to Go back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice < 0 || choice >= recipientCount) {
            System.out.println("Invalid choice. Please select a valid option.");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println(choice);
        if (choice == 0) {
            consoleUtils.clearScreen();
            Donor_UI.main(phoneNumber, password, args);
        } else {
            String[] selectedRequest = matchingRequests.get(choice - 1);
            String recipientName = selectedRequest[0];
            String recipientPhoneNumber = selectedRequest[1];

            acceptRequest(recipientPhoneNumber, recipientName, donorID);
            System.out.println("Accepted. Going back to Dashboard ......");
            consoleUtils.holdTime();
            consoleUtils.clearScreen();
            Donor_UI.main(phoneNumber, password, args);
        }
    }

    private static void acceptRequest(String recipientPhoneNumber, String recipientName, String donorID) {
        DonationManager donationManager = new DonationManager(donorID, recipientName, recipientPhoneNumber);
        donationManager.removeRequest();

        System.out.println("Donation request accepted for " + recipientName + " with contact number " + recipientPhoneNumber);
    }
}
