package basic.banktransfersimulation;

public class Bank {
    public static BankAccount[] getOrderedAccounts(BankAccount from, BankAccount to) {
        BankAccount first, second;
        if (from.getId() < to.getId()) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }
        return new BankAccount[] { first, second };
    }
    public static void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount[] ordered = Bank.getOrderedAccounts(from, to);
        BankAccount first = ordered[0];
        BankAccount second = ordered[1];

        first.getLock().lock();
        second.getLock().lock();

        try {
            if (from.withDraw(amount)) {
                to.deposit(amount);
            }
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }
}


