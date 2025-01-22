package lt.techin.strategy;

public class MyTests extends BaseWarehouseTests{
    @Override
    Warehouse getWarehouse() {
        return new WarehouseImpl();
    }

    @Override
    FilteringStrategy getManufacturerFilteringStrategy(String manufacturer) {
        return new ManufactureFilteringStrategy(manufacturer);
    }

    @Override
    FilteringStrategy getMaxPriceFilteringStrategy(double maxPrice) {
        return new MaxPriceFilteringStrategy(maxPrice);
    }
}
