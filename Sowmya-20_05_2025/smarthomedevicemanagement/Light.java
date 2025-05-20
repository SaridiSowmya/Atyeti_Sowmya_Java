package smarthomedevicemanagement;

public class Light extends Device{
   private int brightness;

    public Light(String deviceId, String deviceName) {
        super(deviceId, deviceName);
        this.brightness=40;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100)
            this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " | Brightness: " + brightness + "%";
    }
}
