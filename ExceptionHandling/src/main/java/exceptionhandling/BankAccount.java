package exceptionhandling;
import java.util.HashSet;
import java.util.Set;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private Set<String> authorizedUsers;

    public BankAccount(String accountNumber, double initialBalance, Set<String> authorizedUsers) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.authorizedUsers = new HashSet<>(authorizedUsers);
    }

    public void deposit(double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException("Cannot deposit negative amount: " + amount);
        }
        balance += amount;
        System.out.println("Deposited: ₹" + amount + ". New Balance: ₹" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Tried to withdraw ₹" + amount + ", but only ₹" + balance + " available.");
        }
        balance -= amount;
        System.out.println("Withdrew: ₹" + amount + ". Remaining Balance: ₹" + balance);
    }

    public void accessAccount(String userId) throws UnauthorizedAccessException {
        if (!authorizedUsers.contains(userId)) {
            throw new UnauthorizedAccessException("User " + userId + " is not authorized to access account " + accountNumber);
        }
        System.out.println("User " + userId + " accessed account " + accountNumber);
    }

    public double getBalance() {
        return balance;
    }
}



