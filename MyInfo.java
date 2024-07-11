import java.util.Scanner;

public class MyInfo {
    private int age;
    private String firstName;
    private String lastName;
    private String cityOfBirth;

    // Constructor
    public MyInfo(String firstName, String lastName, int age, String cityOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cityOfBirth = cityOfBirth;
    }

    // Method to validate the input
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean isValidCity(String city) {
        return city.matches("[a-zA-Z ]+");
    }

    public static boolean isValidAge(int age) {
        return age > 1 && age < 100;
    }

    // Method to display information
    public void displayInfo() {
        System.out.println("My Name is " + firstName + " " + lastName + ".");
        System.out.println("I am " + age + " years old and was born in " + cityOfBirth);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input from the user
            System.out.println("Enter your details in the format <firstname, lastname, age, city>:");
            String input = scanner.nextLine();
            String[] details = input.split(",");

            if (details.length != 4) {
                throw new IllegalArgumentException("Invalid Input");
            }

            String firstName = details[0].trim();
            String lastName = details[1].trim();
            int age = Integer.parseInt(details[2].trim());
            String cityOfBirth = details[3].trim();

            // Validation
            if (!isValidName(firstName) || !isValidName(lastName) || !isValidAge(age) || !isValidCity(cityOfBirth)) {
                throw new IllegalArgumentException("Invalid Input");
            }

            MyInfo myInfo = new MyInfo(firstName, lastName, age, cityOfBirth);
            myInfo.displayInfo();

        } catch (Exception e) {
            System.out.println("Invalid Input");
        } finally {
            scanner.close();
        }
    }
}
