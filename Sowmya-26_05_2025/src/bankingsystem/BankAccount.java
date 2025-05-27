package bankingsystem;

public class BankAccount {

   String accountNumber;
   double  balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal failed: Insufficient balance or invalid amount.");
        }
    }


    public void displayBalance()
    {
        System.out.println("accountnumber"+accountNumber);
        System.out.println("balance"+balance);
    }




}
