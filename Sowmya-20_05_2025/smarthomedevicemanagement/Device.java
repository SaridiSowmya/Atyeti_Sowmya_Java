package smarthomedevicemanagement;

public abstract class Device implements Controllable {

    private String deviceId;
    private String deviceName;
    private boolean status;


    public Device(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.status = false;
    }

    public String getDeviceId() {
        return deviceId;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public boolean isOn() {
        return status;
    }

    @Override
    public void turnOn() {
        status = true;
        System.out.println(deviceName + " turned ON.");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println(deviceName + " turned OFF.");
    }

    @Override
    public String getStatus() {
        return deviceName + " is " + (status ? "ON" : "OFF");
    }
    }

