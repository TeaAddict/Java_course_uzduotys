import utils.CurrencyConverter;

import java.util.Map;
import java.util.Scanner;

public class SupermarketServiceImpl implements SupermarketService {
    private static SupermarketServiceImpl instance;
    private final ProductStorage productStorage;
    private final CashRegister cashRegister;

    private SupermarketServiceImpl(CashRegister cashRegister, ProductStorage productStorage) {
        this.cashRegister = cashRegister;
        this.productStorage = productStorage;
    }

    public static synchronized SupermarketServiceImpl getSupermarketService(CashRegister cashRegister, ProductStorage productStorage) {
        if (instance == null) {
            instance = new SupermarketServiceImpl(cashRegister, productStorage);
            return instance;
        }
        return null;
    }

    public static synchronized SupermarketServiceImpl getSupermarketService() {
        try {
            return instance;
        } catch (Exception e) {
            System.out.println("ERROR, Supermarket does not exist!");
            return null;
        }
    }

    @Override
    public void open() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Welcome to Supermarket!\n");
        System.out.println("Initial Product Inventory:");
        printInv();
        System.out.println();

        System.out.println("Initial Cash Inventory:");
        printCashInv();
        System.out.println();

        while (true) {
            scanner.nextLine();
        }
    }

    @Override
    public void printInv() {
        getProductStorage().getProducts().forEach(product -> System.out.println(product.getName().toUpperCase() + " Quantity: " + product.getStockQuant()));
    }

    @Override
    public void printCashInv() {
        Map<Integer, Integer> currencyStock = getCashRegister().getCurrencyStock();
        currencyStock.forEach((key, val) -> System.out.println("Value: " + CurrencyConverter.centsToEuros(key) + ", quantity: " + val));
    }

    @Override
    public ProductStorage getProductStorage() {
        return productStorage;
    }

    @Override
    public CashRegister getCashRegister() {
        return cashRegister;
    }
}
