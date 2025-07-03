package basic.banktransfersimulation;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int id;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withDraw(double amount)
    {
        if(balance>=amount)
        {
            balance=balance-amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount)
    {
        balance=balance+amount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}
