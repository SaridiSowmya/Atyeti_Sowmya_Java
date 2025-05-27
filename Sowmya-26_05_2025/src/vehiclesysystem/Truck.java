package vehiclesysystem;

public class Truck extends Vehicle{

    private double payloadCapacity;

    public Truck(String make, String model, int year, double payloadCapacity) {
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting truck engine: " + make + " " + model + " (" + year + "), Payload: " + payloadCapacity + " tons");
    }
}
