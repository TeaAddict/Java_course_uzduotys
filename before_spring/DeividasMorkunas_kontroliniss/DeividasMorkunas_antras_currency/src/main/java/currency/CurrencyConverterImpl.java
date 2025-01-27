package currency;

import lt.itakademija.exam.*;

public class CurrencyConverterImpl implements CurrencyConverter {
    private final CurrencyRatesProvider currencyRatesProvider;

    public CurrencyConverterImpl(CurrencyRatesProvider provider)
    {
        this.currencyRatesProvider = provider;
    }

    @Override
    public Money convert(Currency currency, Currency currency1, Money money) {
        Money rate = currencyRatesProvider.getRate(currency, currency1);
        if (rate == null){
            throw new CurrencyConversionException("Rate does not exist");
        }

        Money res = money.multiply(rate);
        if (res.equalTo(money)) {
            throw new CurrencyConversionException("Wrong currency types");
        }

        return res;
    }
}
