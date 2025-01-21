package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {

    public static BigDecimal centToEur(int cents) {
        return BigDecimal.valueOf((double) cents / 100).setScale(2, RoundingMode.HALF_UP);
    }

    public static int eurToCent(BigDecimal eur) {
        return eur.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValueExact();
    }


}
