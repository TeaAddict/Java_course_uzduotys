import java.util.ArrayList;
import java.util.List;

public interface ProductStorage {
    public List<Product> getProducts();

    public Product getProduct(String id);

    public void addProduct(Product product);

    public void removeProduct(String id);

    public void addStock(String id, int stock);

    public void reduceStock(String id, int stock);
}
