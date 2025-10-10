/* This is creative application to help hourly employees create a budget
 before they receive their paycheck. It will help them to realize how much
 they have to spend on bills and necessities as well to see if they will
 have extra money to either spend or save.*/

package practice.work;
public class PayDay {
   private double check;
   private double hours;
   private double payRate;
        
    public PayDay(double hours, double payRate){
        this.hours = hours;
        this.payRate = payRate;
        calculateCheck();
    }

    public double getHours() { return hours; }
    public void setHours(double hours) {
        this.hours = hours;
        calculateCheck();
    }

    public double getPayRate() { return payRate; }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
        calculateCheck();
    }

    public double getCheck() { return check; }

    public void calculateCheck() {
        this.check = (this.hours * this.payRate) * 2;
    }

}