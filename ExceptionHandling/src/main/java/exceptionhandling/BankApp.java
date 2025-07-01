package exceptionhandling;
import java.util.Set;

public class BankApp {
    public static void main(String[] args) {
        Set<String> authorizedUsers = Set.of("user123", "user456");
        BankAccount account = new BankAccount("ACC1001", 1000.0, authorizedUsers);

        try {
            account.accessAccount("user123");
            account.deposit(500);
            account.withdraw(200);

            account.deposit(-100);

        } catch (NegativeDepositException | InsufficientFundsException | UnauthorizedAccessException e) {
            System.err.println(" " + e.getMessage());
        }

        try {

            account.accessAccount("user789");
        } catch (UnauthorizedAccessException e) {
            System.err.println(" " + e.getMessage());
        }

        try {

            account.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.err.println(" " + e.getMessage());
        }

        System.out.println(" Final Balance: ₹" + account.getBalance());
    }

}


