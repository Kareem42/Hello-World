package practice.work;

/* Taxes is an extension of PayDay to give the user an accurate amount of money taken out of the hourly employees pay check.
This will be better used for an hourly employee to create a budget for themselves.This class shows the current tax rates
and deductions from Federal, State of Louisiana, and with-holdings for Social Security and MediCare */

public class Taxes extends PayDay {
    /* Setting the Tax rates with deductions. The State Tax rate is based off
         of Louisiana income bracket range from $12,500 - $50,001. */
    public static final double FED_TAX_RATE = 0.05;
    public static final double STATE_TAX_RATE = 0.04;
    public static final double SS_RATE = 0.062;
    public static final double MEDICARE_RATE = 0.0145;

    private double fedTax;
    private double stateTax;
    private double ss;
    private double medicare;
    private double deductions;

    public Taxes(double hours, double payRate) {
        super(hours, payRate);
        calculateTaxes();
    }

    public void calculateTaxes() {
        double gross = getCheck();
        this.fedTax = gross * FED_TAX_RATE;
        this.stateTax = gross * STATE_TAX_RATE;
        this.ss = gross * SS_RATE;
        this.medicare = gross * MEDICARE_RATE;
        this.deductions = fedTax + stateTax + ss + medicare;
    }

    public double getFedTax() { return fedTax; }
    public double getStateTax() { return stateTax; }
    public double getSS() { return ss; }
    public double getMedicare() { return medicare; }
    public double getDeductions() { return deductions; }

}

