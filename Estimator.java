// This is the Estimator, which will be used to print the user's estimated pay 
// check with information provided by the user.
package practice.work;
import java.util.Scanner;
public class Estimator {
    public static void main(String [] args){
        Taxes t1 = new Taxes();
        PayDay user = new PayDay();
        Scanner scan =  new Scanner(System.in);
        
        // Prompt the user to enter the number of hours worked for the week.
        // It will print out the estimate number of hours for the bi weekly pay
        // period.
        System.out.println("Enter the number of hours worked for the week: ");
        user.hours = scan.nextDouble();
        
        // Prompt the user to enter the current pay grade.
        System.out.println("Enter the current pay grade: ");
        user.payrate = scan.nextDouble();
        
        //Setting the Tax rates with deductions. The State Tax rate is based off
        //of Louisiana income bracket range from $12,500 - $50,001.
        
        t1.setFedTax(user.getCheck() * .05);
        t1.setStateTax(user.getCheck() * .04);
        t1.setSS(user.getCheck() * .062);
        t1.setMedicare(user.getCheck() * .00145);
        t1.setDeductions(t1.FedTax + t1.StateTax + t1.SS + t1.Medicare);
        user.setCheck(t1.deductions - user.check);
        
        // Display the user's input with the deductions and the estimated pay check.
        System.out.println("\nTotal hours worked for bi-weekly pay period: " 
                + user.getHours());
        System.out.println("Current pay grade: " + user.getPayRate());
        System.out.println("Total amount of deductions: " + t1.getDeductions());
        System.out.println("Total estimated amount for this pay period: " 
                + user.getCheck());    
    }
}