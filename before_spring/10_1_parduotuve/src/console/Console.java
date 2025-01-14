package console;

import products.Product;
import products.SimpleProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {


    public static void run() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("\nTo quit, write 'quit', 'q' or enter empty field");
            System.out.println("===================================================");

            System.out.println("Creating new product...");
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            System.out.println();

            if (name.isEmpty() || name.equals("quit") || name.equals("q")) {
                break;
            }

//            System.out.print("Enter product price without tax: ");
//            String priceWithoutTax = scanner.nextLine();
//            System.out.println();
//            if (priceWithoutTax.isEmpty() || priceWithoutTax.equals("quit") || priceWithoutTax.equals("q")) {
//                break;
//            }
             double priceWithoutTax = Double.parseDouble(getUserInput("Enter product price without tax: ", "double"));




            System.out.print("Enter product type (basic, medicine, alcohol, vine): ");
            String productType = scanner.nextLine();
            System.out.println();

            if (productType.isEmpty() || productType.equals("quit") || productType.equals("q")) {
                break;
            }

            if (productType.equals("basic")) {
                products.add(new SimpleProduct(name, Double.parseDouble(priceWithoutTax)), )
            } else if (productType.equals("medicine")) {

            } else if (productType.equals("alcohol")) {

            } else if (productType.equals("vine")) {

            }


        }
        
     
    }

    public static String getUserInput(String requestText, String requiredType){
        Scanner scanner = new Scanner(System.in);

        System.out.println(requestText);
        
        while (true) {

            String input = scanner.nextLine();

            if (input.isEmpty() || input.equals("quit") || input.equals("q")) {
                return "quit";
            }
            
            if (requiredType.equals("double")) {
                try {
                    Double.parseDouble(input);
                    return input;
                } catch (NumberFormatException e){
                    System.out.println("Wrong input!");
                }
            }
        }
    }


}
