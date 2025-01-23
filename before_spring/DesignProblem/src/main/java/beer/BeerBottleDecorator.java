package beer;

import itadesign.beerdrinker.BeerBottle;

public class BeerBottleDecorator implements BeerBottle {
    protected BeerBottle hiddenBeerBottle;

    public BeerBottleDecorator(BeerBottle beerBottle) {
        this.hiddenBeerBottle = beerBottle;
    }

    @Override
    public double getAlcoholContentInPercent() {
        return 0;
    }

    @Override
    public double getVolumeInLiters() {
        return hiddenBeerBottle.getVolumeInLiters();
    }

    @Override
    public void takeASip(double v) {
        hiddenBeerBottle.takeASip(v);
    }


}
