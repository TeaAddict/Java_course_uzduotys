package products;

import operations.CurrencyOperations;

import java.math.BigDecimal;

public interface Product {
    double FRANK_RATE = 0.94;

    String getName();

    BigDecimal getPriceWithTax();

    double getPVM();

    BigDecimal getPriceWithoutTaxEur();

    default BigDecimal getPriceInFranks() {
        BigDecimal priceInFranks = getPriceWithTax().multiply(new BigDecimal(FRANK_RATE));
        return CurrencyOperations.roundedPrice(priceInFranks);
    }

    default BigDecimal getPriceWithPvm() {
        BigDecimal multiplier = BigDecimal.valueOf(getPVM() / 100);
        return CurrencyOperations.roundedPrice(getPriceWithoutTaxEur().add(multiplier.multiply(getPriceWithoutTaxEur())));
    }
}