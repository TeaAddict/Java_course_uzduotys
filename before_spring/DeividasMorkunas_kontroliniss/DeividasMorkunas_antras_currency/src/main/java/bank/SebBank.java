package bank;

import lt.itakademija.exam.*;

import java.util.ArrayList;
import java.util.List;

public class SebBank implements Bank {
    private final List<Customer> customers = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();
    private Long customerIdCount = 1L;
    private Long accountIdCount = 1L;
    private Long operationIdCount = 1L;
    private final CurrencyConverter currencyRatesConverter;

    public SebBank(CurrencyConverter converter) {
        this.currencyRatesConverter = converter;
    }

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName) {
        if (personCode == null || personName == null){
            throw new NullPointerException("Null arguments provided");
        }

        if (customers.stream().anyMatch(customer->customer.getPersonCode().equals(personCode))){
            throw new CustomerCreateException("Customer already exists");
        }

        Customer customer = new Customer(customerIdCount, personCode, personName);
        customerIdCount++;
        customers.add(customer);
        return customer;
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {
        if (customer == null || currency == null){
            throw new NullPointerException("Missing arguments");
        }

        if (!customers.contains(customer)){
            throw new AccountCreateException("Customer does not exist");
        }

        Money money = new Money(0);
        Account acc = new Account(accountIdCount, customer, currency, money);
        customer.addAccount(acc);
        accounts.add(acc);
        accountIdCount++;

        return acc;
    }

    @Override
    public Operation transferMoney(Account account, Account account1, Money money) {
        if (account.getBalance().isLessThan(money)) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        Money transfarableMoney = money;
        if (!account.getCurrency().equals(account1.getCurrency())){
            transfarableMoney = currencyRatesConverter.convert(account.getCurrency(), account1.getCurrency(), money);
        }

        Operation res = new Operation(operationIdCount, account, account1, transfarableMoney);

        operationIdCount++;

        account.setBalance(account.getBalance().substract(transfarableMoney));
        account1.setBalance(account1.getBalance().add(transfarableMoney));

        return res;
    }

    @Override
    public Money getBalance(Currency currency) {
        return accounts.stream().map(account->{
            if (!account.getCurrency().equals(currency)){
                return currencyRatesConverter.convert(account.getCurrency(), currency, account.getBalance());
            }
            return account.getBalance();
        }).reduce(new Money(0), Money::add);
    }
}
