import utils.CurrencyConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CashRegisterImpl implements CashRegister {
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

    int clientDebt = 0;

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
        return centCurrencyStocks.containsKey(denomination);
    }

    @Override
    public boolean checkPayment(BigDecimal num) {
        if (!correctDenomination(CurrencyConverter.eurToCent(num))) {
            return false;
        }
        return true;
    }

    @Override
    public List<BigDecimal> getAcceptedValuesBigDec() {
        return centCurrencyStocks.keySet().stream().map(BigDecimal::new).collect(Collectors.toList());
    }

    @Override
    public void payment(BigDecimal num) {
        clientDebt -= CurrencyConverter.eurToCent(num);
    }

    @Override
    public boolean needsChange() {
        return clientDebt < 0;
    }

    @Override
    public BigDecimal getChange() {
        if (needsChange()) {
            return CurrencyConverter.centToEur(clientDebt).multiply(new BigDecimal(-1));
        }
        return new BigDecimal(0);
    }


    @Override
    public boolean isPayed() {
        return clientDebt <= 0;
    }

    @Override
    public BigDecimal getDebt() {
        return CurrencyConverter.centToEur(clientDebt);
    }
    
}
