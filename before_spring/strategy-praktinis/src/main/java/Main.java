import lt.techin.strategy.ManufactureFilteringStrategy;
import lt.techin.strategy.Product;
import lt.techin.strategy.Warehouse;
import lt.techin.strategy.WarehouseImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(new Product("Jonas", 4, "Bronson"),new Product("Tomas", 50, "Kokson"),new Product("Kestas", 99, "Lopson"));

        Warehouse warehouse = new WarehouseImpl();
        warehouse.addProducts(products);

        warehouse.executeFilteringStrategy(new ManufactureFilteringStrategy("Kokson"));
    }
}
