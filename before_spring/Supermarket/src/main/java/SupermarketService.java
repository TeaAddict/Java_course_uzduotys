public interface SupermarketService {

    public void open();

    public void printInv();

    public void printCashInv();

    public String getAcceptableValues();

    public ProductStorage getProductStorage();

    public CashRegister getCashRegister();


}
