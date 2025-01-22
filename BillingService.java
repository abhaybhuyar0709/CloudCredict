

public interface BillingService {
    double calculateBill(double unitsConsumed, double ratePerUnit);
}

import java .util.Scanner;

public class App {

    public interface BillingService {
        double calculateBill(double unitsConsumed, double ratePerUnit);
    }

    public static class BillingServiceImpl implements BillingService {
        @Override
        public double calculateBill(double unitsConsumed, double ratePerUnit) {
            return unitsConsumed * ratePerUnit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BillingService billingService = new BillingServiceImpl();
        System.out.print("Enter units consumed: ");
        double unitsConsumed = sc.nextDouble();
        System.out.print("Enter rate per unit: ");
        double ratePerUnit = sc.nextDouble();

        double billAmount = billingService.calculateBill(unitsConsumed, ratePerUnit);

        System.out.println("Total Bill Amount: " + billAmount);
    }
}

