package beer;

import itadesign.beerdrinker.BeerBottle;

public class Kalnapilis implements BeerBottle {
    private final double alcoholContentInPercent = 2.2;
    private double volumeInLiters = 2;

    @Override
    public double getAlcoholContentInPercent() {
        return alcoholContentInPercent;
    }

    @Override
    public double getVolumeInLiters() {
        return volumeInLiters;
    }

    @Override
    public void takeASip(double v) {
        volumeInLiters -= v;
    }
}
