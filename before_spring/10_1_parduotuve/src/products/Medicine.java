package products;

import operations.CurrencyOperations;

import java.math.BigDecimal;

public class Medicine implements Product {
    private String name;
    private final double PVM = 9;
    private BigDecimal priceWithoutTaxEur;

    public Medicine(String name, double priceWithoutTaxEur) {
        this.name = name;
        this.priceWithoutTaxEur = new BigDecimal(priceWithoutTaxEur);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return getPriceWithPvm();
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
        return "Medicine{" +
                "name='" + name + '\'' +
                ", priceInFranks=" + this.getPriceInFranks() +
                ", priceInEur=" + this.getPriceWithTax() +
                '}';
    }
}