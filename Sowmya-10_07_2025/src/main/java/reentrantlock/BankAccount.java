package reentrantlock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final int id;
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account-" + id + " : " + balance;
    }
}


