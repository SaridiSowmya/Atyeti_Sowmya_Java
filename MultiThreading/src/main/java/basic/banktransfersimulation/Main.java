package basic.banktransfersimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args)  throws InterruptedException{
        List<BankAccount> accounts = new ArrayList<>();
        int numberOfAccounts = 6;
        double initialBalance = 1000;

        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(new BankAccount(i, initialBalance));
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        Random rand = new Random();

        int transfers = 100;
        for (int i = 0; i < transfers; i++) {
            executor.execute(() -> {
                int fromIndex = rand.nextInt(accounts.size());
                int toIndex;
                do {
                    toIndex = rand.nextInt(accounts.size());
                } while (toIndex == fromIndex);

                BankAccount from = accounts.get(fromIndex);
                BankAccount to = accounts.get(toIndex);
                double amount = rand.nextInt(100);

                Bank.transfer(from, to, amount);
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        double total = accounts.stream().mapToDouble(BankAccount::getBalance).sum();
        System.out.printf(" Final total balance across all accounts: %.2f%n", total);
    }

}




