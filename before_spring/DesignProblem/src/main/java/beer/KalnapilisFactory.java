package beer;

import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

import java.math.BigDecimal;

public class KalnapilisFactory implements BeerFactory {
    private BigDecimal maltInKg = BigDecimal.valueOf(1.0);

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws itadesign.beerdrinker.NoMoreMaltException {
        System.out.println("MALT "+maltInKg);
        if (maltInKg.compareTo(BigDecimal.valueOf(0.025)) < 0){
            throw new itadesign.beerdrinker.NoMoreMaltException("Out of malt");
        }
        maltInKg = maltInKg.subtract(BigDecimal.valueOf(0.025));
        return new DefaultBeerBottle(0.4, 5);
    }

    @Override
    public void receiveMaltShippment(double amountInKilograms) {
        maltInKg = maltInKg.add(BigDecimal.valueOf(amountInKilograms));
    }
}
