package smarthomedevicemanagement;

public interface Controllable {

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract String getStatus();

}
