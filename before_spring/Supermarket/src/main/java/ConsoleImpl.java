import utils.CurrencyConverter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleImpl implements Console {

    SupermarketService supermarket;

    public ConsoleImpl(SupermarketService supermarket) {
        this.supermarket = supermarket;
    }

    public void printInv() {
        supermarket.getProductStorage().getProducts().forEach(product -> System.out.println(product.getName().toUpperCase() + " Quantity: " + product.getStockQuant()));
    }

    public void printCashInv() {
        Map<Integer, Integer> currencyStock = supermarket.getCashRegister().getCurrencyStock();
        currencyStock.forEach((key, val) -> System.out.println("Value: " + CurrencyConverter.centToEur(key) + ", quantity: " + val));
    }

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
                if (supermarket.getProductStorage().getProduct(product.getName()).getStockQuant() < 1) {
                    System.out.println("Out of stock");
                    continue;
                }
                supermarket.getCashRegister().setClientDebt(product.getPrice());
                System.out.println(product + "\n");
            } catch (Exception e) {
                System.out.println("Error: Product not available!\n");
                continue;
            }

            System.out.println("You are trying to buy " + product.getName().toUpperCase() + ". You need to pay " + CurrencyConverter.centToEur(product.getPrice()) + ".");
            System.out.println("Provide bill or coin (accepted values: " + supermarket.getAcceptableValuesEuros() + "):");

            while (!supermarket.getCashRegister().isPayed()) {

                double paymentVal = 0;
                try {
                    paymentVal = Double.parseDouble(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println(e);
                }

                supermarket.getCashRegister().payment(BigDecimal.valueOf(paymentVal));
                System.out.println("You paid " + CurrencyConverter.centToEur(product.getPrice()).subtract(supermarket.getCashRegister().getDebt()) + " in total.");

                if (!supermarket.getCashRegister().isPayed()) {
                    System.out.println("You still need to pay " + supermarket.getCashRegister().getDebt());
                } else {
                    System.out.println("Here is your product: " + product.getName().toUpperCase());
                    supermarket.getProductStorage().reduceStock(product.getName(), 1);
                    if (supermarket.getCashRegister().needsChange()) {
                        System.out.println("Here is your change:\n" + supermarket.getCashRegister().getChange());
                    }
                }

                System.out.println("Updated Product Inventory:");
                printInv();
            }

            System.out.println("THANKS FOR BUYING");


        }
    }
}
