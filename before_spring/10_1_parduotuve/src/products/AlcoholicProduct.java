package products;

import operations.CurrencyOperations;

import java.math.BigDecimal;

public class AlcoholicProduct implements Product {
    private String name;
    private final double PVM = 21;
    private final double EXCISE_EUR_PER_LITRE;
    private BigDecimal priceWithoutTaxEur;

    public AlcoholicProduct(String name, double priceWithoutTaxEur, double alcoholVolume) {
        this.name = name;
        this.priceWithoutTaxEur = new BigDecimal(priceWithoutTaxEur);

        if (alcoholVolume >= 15) {
            EXCISE_EUR_PER_LITRE = 1.26;
        } else {
            EXCISE_EUR_PER_LITRE = 0.89;
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
        return "AlcoholicProduct{" +
                "name='" + name + '\'' +
                ", priceInFranks=" + this.getPriceInFranks() +
                ", priceInEur=" + this.getPriceWithTax() +
                '}';
    }
}
