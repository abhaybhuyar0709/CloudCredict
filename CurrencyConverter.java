import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Declare exchange rates (example rates)
        double usdToInr = 82.50;
        double eurToInr = 89.75;
        double inrToUsd = 0.012;
        double inrToEur = 0.011;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("Currency Converter");
            System.out.println("1. USD to INR");
            System.out.println("2. EUR to INR");
            System.out.println("3. INR to USD");
            System.out.println("4. INR to EUR");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // Input amount
            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();
            double convertedAmount = 0;

            // Perform conversion based on choice
            switch (choice) {
                case 1:
                    convertedAmount = amount * usdToInr;
                    System.out.printf("%.2f USD = %.2f INR%n", amount, convertedAmount);
                    break;
                case 2:
                    convertedAmount = amount * eurToInr;
                    System.out.printf("%.2f EUR = %.2f INR%n", amount, convertedAmount);
                    break;
                case 3:
                    convertedAmount = amount * inrToUsd;
                    System.out.printf("%.2f INR = %.2f USD%n", amount, convertedAmount);
                    break;
                case 4:
                    convertedAmount = amount * inrToEur;
                    System.out.printf("%.2f INR = %.2f EUR%n", amount, convertedAmount);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }
}