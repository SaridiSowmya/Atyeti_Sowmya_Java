package app;
import model.Parcel;
import service.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public class ParcelSystemApp {
    public static void main(String[] args) {
        try {
            Map<String, Parcel> parcels = ParcelDataLoader.loadParcels("C:\\Users\\SowmyaSaridi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sowmya_Java\\Sowmya-10_06_2025\\src\\data\\parcles.txt");
            Thread agent1 = new DeliveryAgent(parcels, "P001");
            Thread agent2 = new DeliveryAgent(parcels, "P002");
            agent1.start();
            agent2.start();
            agent1.join();
            agent2.join();

            ParcelReporter.reportDelayedParcels(parcels, LocalDateTime.now().minusHours(2));
            ParcelReporter.reportByLocation(parcels, "Delhi");

        } catch (IOException | InterruptedException e) {
            System.err.println("System error: " + e.getMessage());
        }
    }
}

