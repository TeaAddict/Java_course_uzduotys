import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CashRegister {
    // {
    //  bills: {
    //          200: 24,
    //          10: 9
    //          }
    //  ,
    //  coins: {
    //          1: 9213,
    //          2: 98,
    // }

    public Map<Integer, Integer> getCurrencyStock();

    public void reduceCurrencyStock(int denomination, int stock);

    public void increaseCurrencyStock(int denomination, int stock);

    public void setCurrencyStock(int denomination, int stock);

    public boolean correctDenomination(int denomination);
}

