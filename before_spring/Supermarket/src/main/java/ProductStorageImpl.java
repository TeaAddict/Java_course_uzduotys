import java.util.ArrayList;
import java.util.List;

public class ProductStorageImpl implements ProductStorage {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProduct(String id) {
        return products.stream().filter(product -> product.getId().equals(id)).findAny().orElseThrow();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(String id) {
        Product product = getProduct(id);
        products.remove(product);
    }

    @Override
    public void addStock(String id, int stock) {
        Product product = getProduct(id);
        product.setStockQuant(product.getStockQuant() + stock);
    }

    @Override
    public void reduceStock(String id, int stock) {
        Product product = getProduct(id);
        product.setStockQuant(product.getStockQuant() - stock);
    }

}
