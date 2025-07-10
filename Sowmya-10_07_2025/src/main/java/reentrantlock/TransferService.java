package reentrantlock;

public class TransferService {
    public void transfer(BankAccount from, BankAccount to, int amount) {
        BankAccount first = from.getId() < to.getId() ? from : to;
        BankAccount second = from.getId() < to.getId() ? to : from;


        first.getLock().lock();
        second.getLock().lock();

        try {
            if (from.withdraw(amount)) {
                to.deposit(amount);
                System.out.printf("Transferred %d from Account-%d to Account-%d%n",
                        amount, from.getId(), to.getId());
            } else {
                System.out.printf("Insufficient funds to transfer %d from Account-%d%n", amount, from.getId());
            }
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }
}
