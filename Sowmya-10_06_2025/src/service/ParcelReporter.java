package service;
import model.Parcel;
import java.time.LocalDateTime;
import java.util.Map;

public class ParcelReporter {
    public static void reportDelayedParcels(Map<String, Parcel> parcels, LocalDateTime cutoff) {
        System.out.println("Delayed parcels before " + cutoff + ":");
        parcels.values().stream()
                .filter(p -> p.getLastUpdated().isBefore(cutoff))
                .forEach(System.out::println);
    }

    public static void reportByLocation(Map<String, Parcel> parcels, String location) {
        System.out.println("\n Parcels in " + location + ":");
        parcels.values().stream()
                .filter(p -> p.getLocation().equalsIgnoreCase(location))
                .forEach(System.out::println);
    }
}



