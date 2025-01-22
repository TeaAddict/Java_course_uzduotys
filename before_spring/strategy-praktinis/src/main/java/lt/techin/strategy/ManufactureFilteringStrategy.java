package lt.techin.strategy;

public class ManufactureFilteringStrategy implements FilteringStrategy{
    private String manufacturer;

    public ManufactureFilteringStrategy(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean filter(Product product) {
        return product.getManufacturer().equalsIgnoreCase(manufacturer);
    }
}
