package myClasses;

import ibank.Account;

import java.math.BigDecimal;
import java.util.UUID;

public class CreditAccount implements Account {
    private String number;
    private String holderName;
    private BigDecimal balance = BigDecimal.valueOf(0);
    private BigDecimal creditLimit;


    public CreditAccount(String holderName, BigDecimal creditLimit) {
        this.number = UUID.randomUUID().toString();
        this.holderName = holderName;
        this.creditLimit = creditLimit;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean deposit(BigDecimal bigDecimal) {
        balance = balance.add(bigDecimal);
        return true;
    }

    @Override
    public boolean withdraw(BigDecimal bigDecimal) {
        BigDecimal combinedCapital = balance.add(creditLimit);

        if( combinedCapital.compareTo(bigDecimal) >= 0){
            balance = balance.subtract(bigDecimal);
            return true;
        }
        return false;
    }
}
