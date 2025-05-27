package bankingsystem;

public class Main {

    public static void main(String[] args) {

                System.out.println("=== Savings Account ===");
                SavingsAccount savings = new SavingsAccount("SA123", 1000.0, 0.05);
                savings.displayBalance();
                savings.deposit(200);
                savings.withdraw(150);


                System.out.println("\n=== Current Account ===");
                CurrentAccount current = new CurrentAccount("CA456", 500.0, 300.0);
                current.displayBalance();
                current.withdraw(100);
                current.deposit(400);

            }
}

