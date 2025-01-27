import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CashRegister {

    public Map<Integer, Integer> getCurrencyStock();

    public void reduceCurrencyStock(int denomination, int stock);

    public void increaseCurrencyStock(int denomination, int stock);

    public void setCurrencyStock(int denomination, int stock);

    public boolean correctDenomination(int denomination);

    public boolean checkPayment(BigDecimal num);

    public List<BigDecimal> getAcceptedValuesBigDec();

    public void payment(BigDecimal num);

    public boolean needsChange();

    public BigDecimal getChange();

    public boolean isPayed();

    public BigDecimal getDebt();

    public void setClientDebt(int clientDebt);

}

