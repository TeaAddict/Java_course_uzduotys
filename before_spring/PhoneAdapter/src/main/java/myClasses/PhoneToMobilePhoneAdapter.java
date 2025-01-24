package myClasses;

import itaphones.phone.MobilePhone;
import itaphones.phone.Phone;

public class PhoneToMobilePhoneAdapter implements Phone {
    private MobilePhone mobilePhone;
    private String response = "";

    public PhoneToMobilePhoneAdapter() {
        this.mobilePhone = new MobilePhone();
    }

    @Override
    public void dial(String s) {
        response = mobilePhone.dial(s);
    }

    @Override
    public String getReponse() {
        return response;
    }
}
