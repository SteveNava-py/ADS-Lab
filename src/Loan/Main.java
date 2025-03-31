package Loan;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Loan cheapLoan = Loan.createLoan("CitiBank", "John", 2.5);
        PersonalLoan myLoan = PersonalLoan.createPersonalLoan("Alice", "BoA", 3.5, 1200);

        //System.out.println(cheapLoan);
        //System.out.println(myLoan);

        Loan anotherLoan = PersonalLoan.createPersonalLoan("Bob", "Wells Fargo", 5.5, 2000);
        //System.out.println(anotherLoan);

        //System.out.println(anotherLoan.getClass());
        //System.out.println(myLoan.getClass());
        //System.out.println(cheapLoan.getClass());

        /*if(cheapLoan instanceof Loan.Loan)
            System.out.println("cheap loan is a loan");
        if(anotherLoan instanceof Loan.PersonalLoan)
            System.out.println("Another Loan.Loan is a loan");
        */

        //Upcasting all objects by storing them in a generic Objects ArrayList
        ArrayList<Object> myMixedArray = new ArrayList<>();
        myMixedArray.add(cheapLoan);
        myMixedArray.add(anotherLoan);
        myMixedArray.add(myLoan);
        //print just Personal Loans
        for(int i=0 ; i < myMixedArray.size(); i++){
            if (myMixedArray.get(i).getClass() == PersonalLoan.class)
                System.out.println(myMixedArray.get(i));

            //Print the Computed Interest rate
            if(myMixedArray.get(i).getClass() == Loan.class) {
                //Downcasting from Object to Loan.Loan
                System.out.println(((Loan) myMixedArray.get(i)).getInterestRate());
            }
            else if(myMixedArray.get(i).getClass() == PersonalLoan.class){
                //Downcasting from Object to Loan.PersonalLoan
                System.out.println(((PersonalLoan) myMixedArray.get(i)).getInterestRate());
            }
        }


    }
}