package model;

public enum TradeType {
    EQUITY(100_000),
    FOREX(500_000),
    CRYPTO(50_000);

    private final double maxAmount;

    TradeType(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }
}
