package console;

import products.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        System.out.println("\nTo quit, write 'quit', 'q' or enter empty field");
        System.out.println("===================================================");

        while (true) {
            Product product = getProduct();
            System.out.println();
            if (product == null) {
                break;
            }
            products.add(product);
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static Product getProduct() {
        String name = (String) getUserInput("Enter product name: ", "String");

        if (name.equals("quit")) {
            return null;
        }

        Object priceWithoutTax = getUserInput("Enter product price without tax: ", "Double");

        if (priceWithoutTax.equals("quit")) {
            return null;
        }

        double priceWithoutTaxDouble = (double) priceWithoutTax;

        while (true) {
            String productType = (String) getUserInput("Enter product type: ", "String");

            switch (productType) {
                case "Basic", "basic" -> {
                    return new SimpleProduct(name, priceWithoutTaxDouble);
                }
                case "Medicine", "medicine" -> {
                    return new Medicine(name, priceWithoutTaxDouble);
                }
                case "Alcohol", "alcohol" -> {
                    Object alcoholStrengthRes = getUserInput("Enter alcohol strength: ", "Double");
                    if (priceWithoutTax.equals("quit")) {
                        return null;
                    }
                    double alcoholStrength = (double) alcoholStrengthRes;

                    return new AlcoholicProduct(name, priceWithoutTaxDouble, alcoholStrength);
                }
                case "Vine", "vine" -> {
                    Object alcoholStrengthRes = getUserInput("Enter alcohol strength: ", "Double");
                    if (priceWithoutTax.equals("quit")) {
                        return null;
                    }
                    double alcoholStrength = (double) alcoholStrengthRes;

                    return new Vine(name, priceWithoutTaxDouble, alcoholStrength);
                }
                case "Quit", "quit" -> {
                    return null;
                }
            }

            System.out.println("Incorrect product type, needs: Basic, Alcohol, Medicine, Vine");
        }
    }

    private static <T>Object getUserInput(String requestText, String requiredType) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(requestText);

        while (true) {

            String input = scanner.nextLine();

            if (input.isEmpty() || input.equals("quit") || input.equals("q")) {
                return "quit";
            }

            if (requiredType.equals("Double")) {
                try {
                    return Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input! Please enter number: ");
                }
            }

            if (requiredType.equals("String")) {
                return input;
            }
        }
    }


}
