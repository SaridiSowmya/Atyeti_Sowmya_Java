package operators;
//Assignment and compound




//Bank Transaction Simulator
//Simulate a banking scenario where:
//
//A user has a balance of 1000
//
//They deposit 200, withdraw 150, then apply a 5% interest on the remaining balance.
//Use arithmetic and compound assignment operators (+=, -=, *=, etc.)

public class BankTransactionSimulator {
        public static void main(String[] args) {
            // Initial balance
            double bal = 1000;
            System.out.println("Initial balance: " + bal);

            // Deposit 200
            bal += 200;
            System.out.println("After depositing 200: " + bal);

            // Withdraw 150
            bal -= 150;
            System.out.println("After withdrawing 150: " + bal);

            // Apply 5% interest
            bal *= 1.05;
            System.out.printf("After applying 5%% interest: %.2f\n", bal);
        }
    }


