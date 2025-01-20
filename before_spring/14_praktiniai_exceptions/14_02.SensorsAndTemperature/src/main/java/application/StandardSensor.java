package application;

public class StandardSensor implements Sensor{

    private int status = 0;

    public StandardSensor(int status) {
        this.status = status;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }

    @Override
    public int read() {
        return status;
    }
}
