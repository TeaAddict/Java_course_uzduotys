package myClasses;

import ibank.Account;
import ibank.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SebBank implements Bank {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    @Override
    public BigDecimal getTotalReserves() {
        return accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account openDebitAccount(String s) {
        if ( getAccountByHolderName(s) != null) {
            return null;
        }

        Account newAcc = new DebitAccount(s);
        accounts.add(newAcc);
        return newAcc;
    }

    @Override
    public Account openCreditAccount(String s, BigDecimal bigDecimal) {
        if ( getAccountByHolderName(s) != null) {
            return null;
        }

        Account newAcc = new CreditAccount(s, bigDecimal);
        accounts.add(newAcc);
        return newAcc;
    }

    @Override
    public Account getAccountByHolderName(String s) {
        return accounts.stream().filter(account->account.getHolderName().equalsIgnoreCase(s)).findFirst().orElse(null);
    }

    @Override
    public Account getAccountByNumber(String s) {
        return accounts.stream().filter(account->account.getNumber().equalsIgnoreCase(s)).findFirst().orElse(null);
    }

    @Override
    public void closeAccount(Account account) {
        accounts.remove(account);
    }
}
