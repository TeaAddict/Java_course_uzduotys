import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        CashRegister cashRegister = new CashRegisterImpl();
        ProductStorage productStorage = new ProductStorageImpl();

        productStorage.addProduct(new ProductImpl("Apple", 20, 2));
        productStorage.addProduct(new ProductImpl("Bike", 5, 5));
        productStorage.addProduct(new ProductImpl("Car", 10, 11));

        cashRegister.setCurrencyStock(500, 23);
        cashRegister.setCurrencyStock(200, 5);
        cashRegister.setCurrencyStock(10, 592);

        SupermarketService supermarket = SupermarketServiceImpl.getSupermarketService(cashRegister, productStorage);

        supermarket.open();
    }
}
