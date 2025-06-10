package exceptionhandling.customexceptionhandling;

public class CustomexceptionHandlingBankSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("Sowmya", "sowmya123", 10000);

        try {
            account.deposit(5000);
            account.withdraw(2000, "sowmya123");
            account.displayBalance("sowmya123");
            account.deposit(-100);

        } catch (NegativeDepositException | InsufficientFundsException | UnauthorizedAccessException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            account.withdraw(1000, "unknownUser");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            account.withdraw(50000, "sowmya123");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
