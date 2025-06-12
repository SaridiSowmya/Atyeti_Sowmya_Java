package service;
import model.Parcel;
import java.time.LocalDateTime;
import java.util.Map;

public class DeliveryAgent extends Thread {
    private final Map<String, Parcel> parcelMap;
    private final String parcelId;

    public DeliveryAgent(Map<String, Parcel> parcelMap, String parcelId) {
        this.parcelMap = parcelMap;
        this.parcelId = parcelId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 2000));
            synchronized (parcelMap) {
                Parcel parcel = parcelMap.get(parcelId);
                if (parcel != null) {
                    parcel.setLocation("Delivered Hub");
                    parcel.setStatus("Delivered");
                    parcel.setLastUpdated(LocalDateTime.now());
                    System.out.println("Updated by " + Thread.currentThread().getName() + ": " + parcel);
                }
            }
        } catch (InterruptedException e) {
            System.err.println(" Update interrupted for parcel: " + parcelId);
        }
    }
}




