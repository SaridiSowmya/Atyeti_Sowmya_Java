package reentrantlock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(1, 5000);
        BankAccount acc2 = new BankAccount(2, 3000);
        BankAccount acc3 = new BankAccount(3, 7000);

        TransferService service = new TransferService();
        ExecutorService executor = Executors.newFixedThreadPool(3);


        executor.submit(() -> service.transfer(acc1, acc2, 1000));
        executor.submit(() -> service.transfer(acc2, acc3, 2000));
        executor.submit(() -> service.transfer(acc3, acc1, 1500));

        executor.shutdown();

        try {
            Thread.sleep(3000);
            System.out.println("\n Final Balances:");
            System.out.println(acc1);
            System.out.println(acc2);
            System.out.println(acc3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


