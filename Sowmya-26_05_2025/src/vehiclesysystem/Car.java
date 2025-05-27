package vehiclesysystem;

public class Car extends Vehicle {

   private int numberOfDoors;

   public Car(String make, String model, int year, int numberOfDoors) {
      super(make, model, year);
      this.numberOfDoors = numberOfDoors;
   }

   @Override
   public void startEngine() {
      System.out.println("Starting car engine: " + make + " " + model + " (" + year + "), Doors: " + numberOfDoors);
   }

}
