package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor{
    private List<Sensor> sensors = new ArrayList<>();
    private List<Integer> reads = new ArrayList<>();

    @Override
    public boolean isOn() {
        return sensors.stream().anyMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        int res = (int) sensors.stream().mapToInt(Sensor::read).average().orElse(0);
        reads.add(res);
        return res;
    }

    public List<Integer> readings(){
        return reads;
    }

    public void addSensor(Sensor add){
        sensors.add(add);
    }
}
