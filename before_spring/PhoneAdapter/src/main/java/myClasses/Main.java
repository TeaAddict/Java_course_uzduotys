package myClasses;

import itaphones.phone.AutomaticDialer;
import itaphones.phone.MobilePhone;

public class Main {
    public static void main(String[] args) {
        PhoneToMobilePhoneAdapter phone = new PhoneToMobilePhoneAdapter();
        String response = AutomaticDialer.dial(phone);
        System.out.println(response);
    }
}
