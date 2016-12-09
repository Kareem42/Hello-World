package practice.work;
// Taxes is an extension of PayDay to give the user an accurate amount of money taken out of the hourly employees pay check.
// This will be better used for an hourly employee to create a budget for themselves.
// This class shows the current tax rates and deductions from Federal, State of Louisiana, and withholdings for Social Security and MediCare.
class Taxes extends PayDay{ 
        double FedTax;    
        double StateTax; //Based on Tax Bracket $12,501 to $50,001  
        double SS;
        double Medicare;
        double deductions;
        
        Taxes(){}
        Taxes(double FedTax, double StateTax, double SS, double Medicare){
            this.FedTax = FedTax;
            this.StateTax = StateTax;
            this.SS = SS;
            this.Medicare = Medicare;
        }
        double getFedTax(){return FedTax;}
        double getStateTax(){return StateTax;}
        double getSS(){return SS;}
        double getMedicare(){return Medicare;}
        double getDeductions(){return deductions;}
        void setFedTax(double newFedTax){FedTax = newFedTax;}
        void setStateTax(double newStateTax){StateTax = newStateTax;}
        void setSS(double newSS){SS = newSS;}
        void setMedicare(double newMedCare){Medicare = newMedCare;}
        void setDeductions(double total){deductions = total;}
}