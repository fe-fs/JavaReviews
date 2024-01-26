/*What is the Facede Design Pattern?
Extremelly simple to use
* When you create a simplified interface that performs many other actions behind the scenes

The Facade Pattern is a structural design pattern that provides a simplified interface
 to a complex system of classes, library or framework. It involves a single class that
 provides simplified methods required by the client and delegates calls to methods of
 existing system classes.

>>Demonstration: Can I withdrawal $50 from bank?
>check if the checking account is valid
>Check if the security code is valid
>Check if funds are available
>Make changes accordingly
* */

public class JavaFacadeDesignPatternReview {

    public static void main(String[] args){

        BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234); //create a new bank account obj with account number and Password

        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(900.00);
        accessingBank.depositCash(200.00);

        accessingBank.withdrawCash(2000.00);

    }

}

class WelcomeToBank{
    //A Java constructor is a special method in a class that is
    // automatically called when an object of that class is created.
    public WelcomeToBank(){
        System.out.println("Welcome to Bank!\n ");
    }
}

/*BankAccountFacade is the facade class. It simplifies the interface for the client.
Instead of dealing with AccountNumberCheck,SecurityCodeCheck, and FundsCheck separately,
 the client only interacts with BankAccountFacade.*/
class BankAccountFacade{

    private int accountNumber;
    private int securityCode;

    AccountNumberCheck acctChecker;
    SecurityCodeCheck codeChecker;
    FundsCheck fundChecker;

    WelcomeToBank bankWelcome;

    public BankAccountFacade(int newAcctNum, int newSecCode){
        accountNumber = newAcctNum;
        securityCode = newSecCode;


        //all objs to handle all of the background things
        bankWelcome = new WelcomeToBank();

        acctChecker = new AccountNumberCheck();
        codeChecker = new SecurityCodeCheck();
        fundChecker = new FundsCheck();

    }

    //provide system a way to be able to get access to the account number and other info
    public int getAccountNumber(){ return accountNumber; }
    public int getSecurityCode(){ return securityCode; }

    //implement option to withdraw
    public void withdrawCash(double cashToGet){

        // acct number, security code is correct and there is enough funds
        if(acctChecker.accountActive(getAccountNumber()) &&
            codeChecker.isCodeCorrect(getSecurityCode()) &&
            fundChecker.haveEnoughMoney(cashToGet)) {

            System.out.println("Transaction Complete\n");
        }else{
            System.out.println("Transaction Failed\n");
        }

    }

    //implement option to deposit
    public void depositCash(double cashToDeposit){

        // acct number, security code is correct
        if(acctChecker.accountActive(getAccountNumber()) &&
                codeChecker.isCodeCorrect(getSecurityCode())) {

            fundChecker.makeDeposit(cashToDeposit);

            System.out.println("Transaction Complete\n");
        }else{
            System.out.println("Transaction Failed\n");
        }

    }

}


//need to make sure that the account number exist and is correct
class AccountNumberCheck{
    private int accountNumber = 12345678;

    public int getAccountNumber(){
        return accountNumber;
    }

    //to check if account provided is there
    public boolean accountActive(int acctNumberToCheck){
        if(acctNumberToCheck == getAccountNumber()){
            return true;
        }else{
            return false;
        }
    }
}

//need to make sure that the pin number exist and is correct
//same as the AccountNumberCheck class
class SecurityCodeCheck {
    private int securityCode = 1234;

    public int getSecurityCode(){
        return securityCode;
    }

    //to check if code provided is there
    public boolean isCodeCorrect(int SecurityNumberToCheck){
        if(SecurityNumberToCheck == getSecurityCode()){
            return true;
        }else{
            return false;
        }
    }
}

class FundsCheck {

    private double cashInAccount = 1000.00;

    public double getCashInAccount(){ return cashInAccount; }

    public void decreaseCashInAccount(double cashWithdraw){
        cashInAccount -= cashWithdraw;
    }

    public void increaseCashInAccount(double cashDeposited){
        cashInAccount += cashDeposited;
    }

    //check for money in account and permit to withdrawal or not
    public boolean haveEnoughMoney(double cashToWithdrawal){

        if(cashToWithdrawal > getCashInAccount()){
            System.out.println("Error: You don't have enough money");
            System.out.println("Current Balance: " + getCashInAccount());

            return false; //NO MONEY!

        }else{
            decreaseCashInAccount(cashToWithdrawal);
            System.out.println("Withdrawal Complete: Current Balance is " + getCashInAccount());

            return true;
        }

    }

    public void makeDeposit(double cashToDeposit){
        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposit Complete: Current Balance: " + getCashInAccount());

    }

}