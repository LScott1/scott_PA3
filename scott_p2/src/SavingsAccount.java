//import java.util.Scanner;

public class SavingsAccount {

    //Scanner scnr = new Scanner(System.in);

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance){
        savingsBalance = balance;
        annualInterestRate = 0;//initial
    }

    public static void modifyInterestRate (double newRate){//new interest rate defined
        annualInterestRate = newRate;
    }

    public double calculateMonthlyInterest(){
        double interest;
        interest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += (savingsBalance * annualInterestRate) / 12;//raise balance with interest
        return interest;
    }

    private double printBalance(){
        return savingsBalance;//just for accessing and printing balance
    }

    public static class Application {
        public static void main(String[] args){
            //set initial balances for the objects
            SavingsAccount saver1 = new SavingsAccount(2000);
            SavingsAccount saver2 = new SavingsAccount(3000);

            for (int i = 0; i < 12; i++){
                System.out.println("[Month " + (i+1) + "]");

                System.out.println("Saver 1 balance: " + saver1.printBalance());
                saver1.modifyInterestRate(.04);//new interest rate
                saver1.calculateMonthlyInterest();

                System.out.println("Saver 2 balance: " + saver2.printBalance());
                saver2.modifyInterestRate(.04);
                saver2.calculateMonthlyInterest();
            }//end for

            System.out.println("____________________________________");
            System.out.println("Next 12 month period: ");
            System.out.println("____________________________________");

            for (int j = 0; j < 12; j++){
                System.out.println("[Month " + (j+1) + "]");

                System.out.println("Saver 1 balance: " + saver1.printBalance());
                saver1.modifyInterestRate(.05);
                saver1.calculateMonthlyInterest();

                System.out.println("Saver 2 balance: " + saver2.printBalance());
                saver2.modifyInterestRate(.05);
                saver2.calculateMonthlyInterest();
            }//end for
        }//end main
    }//end predefined
}//end class SavingsAccount
