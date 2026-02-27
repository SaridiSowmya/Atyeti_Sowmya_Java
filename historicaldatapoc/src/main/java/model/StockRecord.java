package model;

import java.time.LocalDate;


public class StockRecord {

    private final int recordId;
    private final String registrationNumber;
    private final String symbol;
    private final LocalDate date;
    private final double open;
    private final double close;
    private final double high;
    private final double low;
    private final long volume;

    // This is the only field we modify during processing
    private int isUpdated; // 400 or 401

    public StockRecord(int recordId, String registrationNumber, String symbol,
                       LocalDate date, double open, double close,
                       double high, double low, long volume) {
        this.recordId = recordId;
        this.registrationNumber = registrationNumber;
        this.symbol = symbol;
        this.date = date;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.isUpdated = 400; // default, will update later
    }

    // Getters only for all CSV fields
    public int getRecordId() { return recordId; }
    public String getRegistrationNumber() { return registrationNumber; }
    public String getSymbol() { return symbol; }
    public LocalDate getDate() { return date; }
    public double getOpen() { return open; }
    public double getClose() { return close; }
    public double getHigh() { return high; }
    public double getLow() { return low; }
    public long getVolume() { return volume; }

    // Getter + Setter for the field we update during processing
    public int getIsUpdated() { return isUpdated; }
    public void setIsUpdated(int isUpdated) { this.isUpdated = isUpdated; }

    @Override
    public String toString() {
        return "StockRecord{" +
                "recordId=" + recordId +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", symbol='" + symbol + '\'' +
                ", date=" + date +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                ", isUpdated=" + isUpdated +
                '}';
    }
}
