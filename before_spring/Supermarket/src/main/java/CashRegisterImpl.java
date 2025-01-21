import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CashRegisterImpl implements CashRegister {
    private static final int[] currencyDenominations = new int[]{20000,
            10000,
            5000,
            2000,
            1000,
            500,
            200,
            100,
            50,
            20,
            10,
            1,};

    private Map<Integer, Integer> centCurrencyStocks = new HashMap<>() {{
        put(20000, 0);
        put(10000, 0);
        put(5000, 0);
        put(2000, 0);
        put(1000, 0);
        put(500, 0);
        put(200, 0);
        put(100, 0);
        put(50, 0);
        put(20, 0);
        put(10, 0);
        put(1, 0);
    }};

    @Override
    public Map<Integer, Integer> getCurrencyStock() {
        return centCurrencyStocks;
    }

    @Override
    public void reduceCurrencyStock(int denomination, int stock) {
        if (!correctDenomination(denomination)) {
            System.out.println("Incorrect denomination!");
            return;
        }

        centCurrencyStocks.compute(denomination, (k, currentStock) -> currentStock - stock);
    }

    @Override
    public void increaseCurrencyStock(int denomination, int stock) {
        if (!correctDenomination(denomination)) {
            System.out.println("Incorrect denomination!");
            return;
        }

        centCurrencyStocks.compute(denomination, (k, currentStock) -> currentStock + stock);
    }

    @Override
    public void setCurrencyStock(int denomination, int stock) {
        if (!correctDenomination(denomination)) {
            System.out.println("Incorrect denomination!");
            return;
        }

        centCurrencyStocks.put(denomination, stock);
    }

    @Override
    public boolean correctDenomination(int denomination) {
        return Arrays.stream(currencyDenominations).anyMatch(currency -> currency == denomination);
    }

}
