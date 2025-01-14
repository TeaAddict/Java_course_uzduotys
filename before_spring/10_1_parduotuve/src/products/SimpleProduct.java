package products;

import operations.CurrencyOperations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleProduct implements Product {
    private String name;
    private final double PVM = 21;
    private BigDecimal priceWithoutTaxEur;

    public SimpleProduct(String name, double priceWithoutTaxEur) {
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
        return "SimpleProduct{" +
                "name='" + name + '\'' +
                ", priceInFranks=" + getPriceInFranks() +
                ", priceInEur=" + getPriceWithTax() +
                '}';
    }
}
