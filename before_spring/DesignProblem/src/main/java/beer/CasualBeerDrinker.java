package beer;

import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;

public class CasualBeerDrinker extends BeerConsumer {

    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {
        boolean surpassesBloodThreshold = (this.getBloodAlcoholContentInLiters()) > 0.120;

        if (beerBottle.getVolumeInLiters() <= 0.5 && beerBottle.getAlcoholContentInPercent() < 6 && !surpassesBloodThreshold){

            return true;
        } else {
            return false;
        }
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean mightBeAPoliceMan) {
        if (mightBeAPoliceMan){
            return new BeerBottleDecorator(beerBottle);
        }
        return beerBottle;
    }
}
