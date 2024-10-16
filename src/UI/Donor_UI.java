package UI;

import java.util.List;
import java.util.Scanner;

class Donor_UI  {

    private String name;
    private String phoneNumber;
    private String DonorID;
    private String address;
    private String bloodGroup;
    private List<DonationHistory_UI> donationHistory;
    private int points;
    private boolean isEligible;

    public void login(String phoneNumber, String password) {
        // Implementation
    }

    public void logout() {
        // Implementation
    }

    public void donateBlood() {
        // Implementation
    }

    public void acceptRequest() {
        // Implementation
    }

    public boolean checkEligibility() {
        // Implementation
        return false;
    }

    public void notifyUser() {
        // Implementation
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public List<DonationHistory_UI> getDonationHistory() {
        return donationHistory;
    }

    public int getPoints() {
        return points;
    }

    public boolean getIsEligible() {
        return isEligible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setDonationHistory(List<DonationHistory_UI> donationHistory) {
        this.donationHistory = donationHistory;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setIsEligible(boolean isEligible) {
        this.isEligible = isEligible;
    }

    public String getDonorID() {
        return DonorID;
    }

    public void setDonorID(String DonorID) {
        this.DonorID = DonorID;
    }


    public static void main(String[] args) {
        Donor_UI donor = new Donor_UI();
        donor.setName("Donor 1");
        donor.setDonorID("D001");
        donor.setBloodGroup("A+");
        donor.setPoints(10);
        donor.setIsEligible(true);
        final String RED = "\033[31m";
        final String RESET = "\033[0m";


        System.out.println("==============================================================================================");
        System.out.println("             Dashboard");
        System.out.println("==============================================================================================");
        System.out.println("Welcome, " + donor.getName());
        System.out.println("Donor ID: " + donor.getDonorID());
        System.out.println("Points: " + donor.getPoints());
        if (donor.getIsEligible()) {
            System.out.println("You are eligible to donate blood.");
        } else {
            System.out.println("You are not eligible to donate blood.");
        }
        System.out.println("==============================================================================================");
        System.out.println();
        System.out.println(RED + "[1]" + RESET + " View Donation History");
        System.out.println(RED + "[2]" + RESET + " View Donation Requests");
        System.out.println(RED + "[3]" + RESET + " View Profile");
        System.out.println(RED + "[4]" + RESET + " Logout");
        System.out.println("==============================================================================================");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                DonationHistory_UI.main(args);
                break;
            case 2:
                BloodRequests_UI.main(args);
                break;
            case 3:

                break;
            case 4:
                System.out.printf("Logging out...");
                Login_UI.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
        }


    }
}
