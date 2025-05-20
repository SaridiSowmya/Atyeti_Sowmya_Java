package smarthomedevicemanagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Device> devices = new ArrayList<>();

        Light livingRoomLight = new Light("L1", "Living Room Light");
        livingRoomLight.turnOn();
        livingRoomLight.setBrightness(60);
        devices.add(livingRoomLight);

        Thermostat homeThermostat = new Thermostat("T1", "Home Thermostat");
        homeThermostat.setTemperature(21.5);
       // homeThermostat.turnOn();
        homeThermostat.turnOff();
        devices.add(homeThermostat);

        SecurityCamera frontCamera = new SecurityCamera("C1", "Front Door Camera");
        frontCamera.turnOn();
        frontCamera.startRecording();
        devices.add(frontCamera);

        System.out.println("\n=== Device Status Report ===");
        for (Device device : devices) {
            System.out.println(device.getStatus());
        }
    }

}
