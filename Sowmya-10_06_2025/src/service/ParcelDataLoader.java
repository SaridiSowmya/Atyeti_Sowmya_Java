package service;
import model.Parcel;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ParcelDataLoader {
    public static Map<String, Parcel> loadParcels(String filePath) throws IOException {
        Map<String, Parcel> parcelMap = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            try {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                String status = parts[1].trim();
                String location = parts[2].trim();
                LocalDateTime updated = LocalDateTime.parse(parts[3].trim(), formatter);
                parcelMap.put(id, new Parcel(id, status, location, updated));
            } catch (Exception e) {
                System.err.println("Malformed line skipped: " + line);
            }
        }
        return parcelMap;
    }
}


