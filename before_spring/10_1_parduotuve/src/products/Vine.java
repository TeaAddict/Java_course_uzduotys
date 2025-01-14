package products;

import operations.CurrencyOperations;

import java.math.BigDecimal;

public class Vine implements Product {
    private String name;
    private final double PVM = 21;
    private final double EXCISE_EUR_PER_LITRE;
    private BigDecimal priceWithoutTaxEur;

    public Vine(String name, double priceWithoutTaxEur, double alcoholVolume) {
        this.name = name;
        this.priceWithoutTaxEur = new BigDecimal(priceWithoutTaxEur);
        
        if (alcoholVolume >= 8.5) {
            EXCISE_EUR_PER_LITRE = 0.72;
        } else {
            EXCISE_EUR_PER_LITRE = 0.28;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return getPriceWithPvm().add(BigDecimal.valueOf(EXCISE_EUR_PER_LITRE));
    }

    @Override
    public double getPVM() {
        return PVM;
    }

    @Override
    public BigDecimal getPriceWithoutTaxEur() {
        return priceWithoutTaxEur;
    }

    @Override
    public String toString() {
        return "Vine{" +
                "name='" + name + '\'' +
                ", priceInFranks=" + this.getPriceInFranks() +
                ", priceInEur=" + this.getPriceWithTax() +
                '}';
    }
}
