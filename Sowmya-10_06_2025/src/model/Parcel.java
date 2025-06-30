package model;
import java.time.LocalDateTime;

public class Parcel {
    private String id;
    private String status;
    private String location;
    private LocalDateTime lastUpdated;

    public Parcel(String id, String status, String location, LocalDateTime lastUpdated) {
        this.id = id;
        this.status = status;
        this.location = location;
        this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}


