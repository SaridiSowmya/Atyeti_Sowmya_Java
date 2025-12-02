package model;

public class StockMetrics {

    private double minPrice;
    private double maxPrice;
    private double avgPrice;

    public StockMetrics(double minPrice, double maxPrice, double avgPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.avgPrice = avgPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    @Override
    public String toString() {
        return "StockMetrics{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", avgPrice=" + avgPrice +
                '}';
    }
}

