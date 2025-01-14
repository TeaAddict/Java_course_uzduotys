package operations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyOperations {


    public static BigDecimal roundedPrice(BigDecimal num) {
        return num.setScale(2, RoundingMode.HALF_UP);
    }


    public static BigDecimal convertToFranks(BigDecimal num, double pvm) {
        return num.multiply(new BigDecimal("0.96"));
    }
}
