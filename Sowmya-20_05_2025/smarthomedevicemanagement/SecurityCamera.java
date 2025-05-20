package smarthomedevicemanagement;

public class SecurityCamera extends Device{
    public boolean monitoring;

    public SecurityCamera(String deviceId, String deviceName) {
        super(deviceId, deviceName);
        this.monitoring=false;

    }

    public void startRecording() {
        if (isOn()) {
            monitoring = true;
            System.out.println(getDeviceName() + " started recording.");
        } else {
            System.out.println(getDeviceName() + " is OFF. Cannot start recording.");
        }
    }

    public void stopMonitoring() {
        monitoring = false;
        System.out.println(getDeviceName() + " stopped recording.");
    }

    public boolean isMonitoring() {
        return monitoring;
    }


    @Override
    public String getStatus() {
        return super.getStatus() + " | Monitoring: " + (monitoring ? "Yes" : "No");
    }
}

