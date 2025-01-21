import utils.CurrencyConverter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        while (true) {
            System.out.print("\nWhat would you like to buy? Type in the name of the desired product: ");
            String input = scanner.nextLine();
            System.out.println();

            Product product;
            try {
                product = getProductStorage().getProduct(input);
                System.out.println(product + "\n");
            } catch (Exception e) {
                System.out.println("Error: Product not available!\n");
                continue;
            }

            System.out.println("You are trying to buy " + product.getName().toUpperCase() + ". You need to pay " + CurrencyConverter.centToEur(product.getPrice()) + ".");
            System.out.println("Provide bill or coin (accepted values: " + getAcceptableValues() + "):");
            String paymentVal = scanner.nextLine();

            System.out.println("You paid " + CurrencyConverter.centToEur(product.getPrice()).subtract(cashRegister.getDebt()) + " in total.");

        }
    }

    @Override
    public void printInv() {
        getProductStorage().getProducts().forEach(product -> System.out.println(product.getName().toUpperCase() + " Quantity: " + product.getStockQuant()));
    }


    @Override
    public void printCashInv() {
        Map<Integer, Integer> currencyStock = getCashRegister().getCurrencyStock();
        currencyStock.forEach((key, val) -> System.out.println("Value: " + CurrencyConverter.centToEur(key) + ", quantity: " + val));
    }

    @Override
    public String getAcceptableValues() {
        return cashRegister.getAcceptedValuesBigDec().stream().map(BigDecimal::toString).collect(Collectors.joining(", "));
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
