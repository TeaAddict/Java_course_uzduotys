package myClasses;

import ibank.Account;

import java.math.BigDecimal;
import java.util.UUID;

public class DebitAccount implements Account {
    private String number;
    private String holderName;
    private BigDecimal balance;

    public DebitAccount(String holderName) {
        this.number = UUID.randomUUID().toString();
        this.holderName = holderName;
        this.balance = BigDecimal.valueOf(0);
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
        if( balance.compareTo(bigDecimal) >= 0){
            balance = balance.subtract(bigDecimal);
            return true;
        }
        return false;
    }
}
