import utils.CurrencyConverter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SupermarketServiceImpl implements SupermarketService {
    private static SupermarketServiceImpl instance;
    private final ProductStorage productStorage;
    private final CashRegister cashRegister;

    private SupermarketServiceImpl(CashRegister cashRegister, ProductStorage productStorage) {
        this.cashRegister = cashRegister;
        this.productStorage = productStorage;
    }

    public static synchronized SupermarketServiceImpl getSupermarketService(CashRegister cashRegister, ProductStorage productStorage) {
        if (instance == null) {
            instance = new SupermarketServiceImpl(cashRegister, productStorage);
            return instance;
        }
        return null;
    }

    public static synchronized SupermarketServiceImpl getSupermarketService() {
        try {
            return instance;
        } catch (Exception e) {
            System.out.println("ERROR, Supermarket does not exist!");
            return null;
        }
    }


    @Override
    public String getAcceptableValues() {
        return cashRegister.getAcceptedValuesBigDec().stream().map(BigDecimal::toString).collect(Collectors.joining(", "));
    }

    @Override
    public ProductStorage getProductStorage() {
        return productStorage;
    }

    @Override
    public CashRegister getCashRegister() {
        return cashRegister;
    }
}
