// This is creative application to help hourly employees create a bugdet
// before they receive their paycheck. It will help them to realize how much 
// they have to spend on bills and necessities as well to see if they will 
// have extra money to either spend or save.

package practice.work;
public class PayDay {
    double check;
    double hours;
    double payrate;
        
    PayDay(){}
    PayDay(double check, double hours){
        this.check = check;
        this.hours = hours;
    }
    double getPayRate(){return payrate;}
    double getHours(){return hours * 2;}
    double getCheck(){return payrate * getHours();}
    void setCheck(double newPC){check = newPC;}
     
}