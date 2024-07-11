import java.util.Scanner;

public class BirthDay {
    @SuppressWarnings("unused")
    private String name;
    private int birthMonth;
    private int birthDay;
    private int birthYear;

    // Constructor
    public BirthDay(String name, int birthMonth, int birthDay, int birthYear) {
        this.name = name;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    // Method to validate the input
    public static boolean isValidBirthDay(int birthMonth, int birthDay, int birthYear) {
        if (birthMonth < 1 || birthMonth > 12) return false;
        if (birthDay < 1 || birthDay > 31) return false;
        if (birthYear < 1950 || birthYear > 2024) return false;
        return true;
    }

    // Method to display birthday information in different formats
    public void displayBirthDayInfoAsUS(String relation) {
        System.out.println("In the USA " + relation + "birthday is: " + String.format("%02d/%02d/%d", birthMonth, birthDay, birthYear));
    }

    public void displayBirthDayInfoAsUK(String relation) {
        System.out.println("In England " + relation + "birthday is: " + String.format("%02d/%02d/%d", birthDay, birthMonth, birthYear));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input for yourself
            System.out.println("Enter your details in the format <Name, Month, Day, Year>:");
            String[] personalDetails = scanner.nextLine().split(",");
            String yourName = personalDetails[0].trim();
            int yourBirthMonth = Integer.parseInt(personalDetails[1].trim());
            int yourBirthDay = Integer.parseInt(personalDetails[2].trim());
            int yourBirthYear = Integer.parseInt(personalDetails[3].trim());

            if (!isValidBirthDay(yourBirthMonth, yourBirthDay, yourBirthYear)) {
                throw new IllegalArgumentException("Invalid Input");
            }

            BirthDay yourBirthDayInfo = new BirthDay(yourName, yourBirthMonth, yourBirthDay, yourBirthYear);

            // Input for your friend
            System.out.println("Enter your friend's details in the format <Name, Month, Day, Year>:");
            String[] friendDetails = scanner.nextLine().split(",");
            String friendName = friendDetails[0].trim();
            int friendBirthMonth = Integer.parseInt(friendDetails[1].trim());
            int friendBirthDay = Integer.parseInt(friendDetails[2].trim());
            int friendBirthYear = Integer.parseInt(friendDetails[3].trim());

            if (!isValidBirthDay(friendBirthMonth, friendBirthDay, friendBirthYear)) {
                throw new IllegalArgumentException("Invalid Input");
            }

            BirthDay friendBirthDayInfo = new BirthDay(friendName, friendBirthMonth, friendBirthDay, friendBirthYear);

            // Display the information
            System.out.println();
            yourBirthDayInfo.displayBirthDayInfoAsUS("my ");
            yourBirthDayInfo.displayBirthDayInfoAsUK("my ");

            System.out.println();
            friendBirthDayInfo.displayBirthDayInfoAsUS("my friend " + friendName + "'s ");
            friendBirthDayInfo.displayBirthDayInfoAsUK("my friend " + friendName + "'s ");

        } catch (Exception e) {
            System.out.println("Invalid Input");
        } finally {
            scanner.close();
        }
    }
}