package lt.techin.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WarehouseImpl implements Warehouse {
    private List<Product> products = new ArrayList<>();

    @Override
    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }

    @Override
    public List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy) {
        return products.stream().filter(filteringStrategy::filter).collect(Collectors.toList());
    }
}
