package beer;

import exceptions.NoMoreMaltException;
import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;

import java.math.BigDecimal;

public class KalnapilisFactory implements BeerFactory {
    private BigDecimal maltInKg = BigDecimal.valueOf(1.0);

    @Override
    public DefaultBeerBottle produceNextBeerBottle() {
        System.out.println("MALT "+maltInKg);
        if (maltInKg.compareTo(BigDecimal.valueOf(0.025)) < 0){
            throw new NoMoreMaltException("Out of malt");
        }
        maltInKg.subtract(BigDecimal.valueOf(0.025));
        return new DefaultBeerBottle(0.4, 5);
    }

    @Override
    public void receiveMaltShippment(double amountInKilograms) {
        maltInKg += amountInKilograms;
    }
}
