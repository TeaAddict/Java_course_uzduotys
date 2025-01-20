package application;

public class TemperatureSensor implements Sensor {
    private boolean status = false;

    @Override
    public boolean isOn() {
        return status;
    }

    @Override
    public void setOn() {
        status = true;
    }

    @Override
    public void setOff() {
        status = false;
    }

    @Override
    public int read() {
        if (!status) throw new IllegalStateException();

        return (int)(Math.random() * (30 - (-30)) + -30);
    }
}
