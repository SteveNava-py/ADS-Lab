package Loan;

public class PersonalLoan extends Loan {
    private String taxDoc;
    private double fees;

    public static PersonalLoan createPersonalLoan(String client, String lender, double rate, double fees){
        PersonalLoan pl = new PersonalLoan();
        pl.setClient(client);
        pl.setLender(lender);
        pl.setInterestRate(rate);
        pl.fees = fees;
        return pl;
    }

    //Overriding the computeInterestRate of the parent class Loan.Loan
    public double computeInterestRate(){
        return getInterestRate() + (fees/12);
    }

    public String toString(){
        return "This is a personal Loan.Loan object ";
    }

}
