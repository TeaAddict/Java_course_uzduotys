import utils.CurrencyConverter;

import java.util.Map;
import java.util.Scanner;

public class ConsoleImpl implements Console {

    SupermarketService supermarket;

    public ConsoleImpl(SupermarketService supermarket) {
        this.supermarket = supermarket;
    }

    @Override
    public void printInv() {
        supermarket.getProductStorage().getProducts().forEach(product -> System.out.println(product.getName().toUpperCase() + " Quantity: " + product.getStockQuant()));
    }

    @Override
    public void printCashInv() {
        Map<Integer, Integer> currencyStock = supermarket.getCashRegister().getCurrencyStock();
        currencyStock.forEach((key, val) -> System.out.println("Value: " + CurrencyConverter.centToEur(key) + ", quantity: " + val));
    }

    @Override
    public void start() {
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
                product = supermarket.getProductStorage().getProduct(input);
                System.out.println(product + "\n");
            } catch (Exception e) {
                System.out.println("Error: Product not available!\n");
                continue;
            }

            System.out.println("You are trying to buy " + product.getName().toUpperCase() + ". You need to pay " + CurrencyConverter.centToEur(product.getPrice()) + ".");
            System.out.println("Provide bill or coin (accepted values: " + supermarket.getAcceptableValues() + "):");
            String paymentVal = scanner.nextLine();

            System.out.println("You paid " + CurrencyConverter.centToEur(product.getPrice()).subtract(supermarket.getCashRegister().getDebt()) + " in total.");
        }
    }
}
