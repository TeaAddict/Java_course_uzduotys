package tests;

import beer.CasualBeerDrinker;
import beer.KalnapilisFactory;
import itadesign.beerdrinker.BeerConsumer;
import itadesign.beerdrinker.BeerFactory;
import itadesign.test.AbstractBeerTest;

public class MyTests extends AbstractBeerTest {
    @Override
    protected BeerConsumer getBeerConsumer() {
        return new CasualBeerDrinker();
    }

    @Override
    protected BeerFactory getBeerFactory() {
        return new KalnapilisFactory();
    }
}
