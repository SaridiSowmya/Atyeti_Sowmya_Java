package exceptionhandling.customexceptionhandling;

public class BankAccount {
    private String accountHolder;
    private String authorizedUser;
    private double balance;

    public BankAccount(String accountHolder, String authorizedUser, double balance) {
        this.accountHolder = accountHolder;
        this.authorizedUser = authorizedUser;
        this.balance = balance;
    }

    public void deposit(double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException("Cannot deposit a negative amount.");
        }
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". New Balance: ₹" + balance);
    }

    public void withdraw(double amount, String user) throws InsufficientFundsException {
        if (!user.equals(authorizedUser)) {
            throw new UnauthorizedAccessException("User not authorized to access this account.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
        System.out.println("Withdrawn ₹" + amount + ". Remaining Balance: ₹" + balance);
    }

    public void displayBalance(String user) throws UnauthorizedAccessException {
        if (!user.equals(authorizedUser)) {
            throw new UnauthorizedAccessException("User not authorized to view this account.");
        }
        System.out.println("Current Balance: ₹" + balance);
    }
}



