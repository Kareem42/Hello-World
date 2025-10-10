// This is the Estimator, which will be used to print the user's estimated pay 
// check with information provided by the user.
package practice.work;
import java.util.Scanner;
public class Estimator {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        double hours;
        do {
            System.out.print("Enter the number of hours worked for the current pay period: ");
            hours = scan.nextDouble();
            if (hours < 0) {
                System.out.println("Please enter a positive number.");
            }
        } while (hours < 0);

        double payRate;
        do {
            System.out.print("Enter your hourly pay rate: ");
            payRate = scan.nextDouble();
            if (payRate < 0) {
                System.out.println("Please enter a positive number.");
            }
        } while (payRate < 0);

        System.out.println("----------------");
        System.out.println();

        System.out.println("Your worked a total of: " + hours);
        System.out.println("Your pay rate is: " + payRate);

        System.out.println("----------------");
        System.out.println();

        Taxes taxes = new Taxes(hours, payRate);

        System.out.printf("Gross Pay: $%.2f\n", taxes.getCheck());
        System.out.printf("Federal Tax: $%.2f\n", taxes.getFedTax());
        System.out.printf("State Tax: $%.2f\n", taxes.getStateTax());
        System.out.printf("Social Security: $%.2f\n", taxes.getSS());
        System.out.printf("Medicare: $%.2f\n", taxes.getMedicare());
        System.out.printf("Total Deductions: $%.2f\n", taxes.getDeductions());
        System.out.println("----------------");
        System.out.printf("Net Pay: $%.2f\n", taxes.getCheck() - taxes.getDeductions());

        scan.close();
    }
}