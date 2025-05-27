package bankingsystem;

class SavingsAccount extends BankAccount {
    private double interestRate; 

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        double interest = amount * interestRate;
        super.deposit(amount + interest);
        System.out.println("Interest added: " + interest);
    }
}









