package Loan;

public class Loan {
    private double interestRate;
    private String client;
    private String lender;

    public static Loan createLoan(String lender, String client){
        Loan loan = new Loan();
        loan.lender = lender;
        loan.client = client;
        return loan;
    }

    //Overloading the createLoan Method
    public static Loan createLoan(String lender, String client, double rate){
        Loan loan = new Loan();
        loan.lender = lender;
        loan.client = client;
        loan.interestRate = rate;
        return loan;
    }

    public double computeInterestRate(){
        return interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getClient() {
        return client;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public String getLender() {
        return lender;
    }

    //Overriding the toString from parent class: Object
    public String toString(){
        return "This is a loan Object for Client: " + client + " Lender: " + lender +
        " Rate: " + interestRate;
    }

}
