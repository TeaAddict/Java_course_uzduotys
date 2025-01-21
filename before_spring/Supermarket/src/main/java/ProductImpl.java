import java.util.UUID;

public class ProductImpl implements Product {
    private String id;
    private String name;
    private int priceInCents;
    private int stockQuant;

    public ProductImpl(String name, int priceInCents, int stockQuant) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.priceInCents = priceInCents;
        this.stockQuant = stockQuant;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return priceInCents;
    }

    @Override
    public int getStockQuant() {
        return stockQuant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public void setStockQuant(int stockQuant) {
        this.stockQuant = stockQuant;
    }

    @Override
    public String toString() {
        return "ProductImpl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", priceInCents=" + priceInCents +
                ", stockQuant=" + stockQuant +
                '}';
    }
}
