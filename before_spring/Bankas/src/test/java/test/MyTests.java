package test;

import ibank.Bank;
import ibank.BaseBankTest;
import myClasses.SebBank;

public class MyTests extends BaseBankTest {

    @Override
    protected Bank createBank() {
        return new SebBank();
    }
}
