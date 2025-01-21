package utils;

import java.math.BigDecimal;

public class CurrencyConverter {

    public static BigDecimal centsToEuros(int cents) {
        return BigDecimal.valueOf((double) cents / 100);
    }
}
