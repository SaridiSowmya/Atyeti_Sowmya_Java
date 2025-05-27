package bankingsystem;

class SavingsAccount extends BankAccount {
    private double interestRate; // e.g. 0.03 = 3%

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









