package smarthomedevicemanagement;

public class Thermostat extends Device{

    private double temperature;

    public Thermostat(String deviceId, String deviceName) {
        super(deviceId, deviceName);
        this.temperature=22.0;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " | Temperature: " + temperature + "°C";
    }
}


