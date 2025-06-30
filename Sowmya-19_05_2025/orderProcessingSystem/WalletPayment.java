package orderProcessingSystem;

    public class WalletPayment implements Payment {

        private String walletId;

        public WalletPayment(String walletId) {
            this.walletId = walletId;
        }

        public void pay(double amount) {
            System.out.println("Processing wallet payment of $" + amount + " for wallet ID: " + walletId + "...");
        }
    }

