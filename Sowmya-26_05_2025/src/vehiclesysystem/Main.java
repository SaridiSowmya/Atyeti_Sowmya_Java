package vehiclesysystem;

public class Main {
    public static void startVehicle(Vehicle v) {
        v.startEngine();
    }
    public static void main(String[] args) {
        Vehicle generic = new Vehicle("Generic", "Transport", 2000);
        Car car = new Car("Toyota", "Corolla", 2021, 4);
        Truck truck = new Truck("Volvo", "FH16", 2022, 18.5);

        System.out.println("=== Demonstrating Polymorphism ===");
        startVehicle(generic);
        startVehicle(car);
        startVehicle(truck);
    }
}
