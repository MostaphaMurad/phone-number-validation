package com.arpu.shofha.msisdnvalidation.Service.Imp;

import com.arpu.shofha.msisdnvalidation.Service.IsPhoneNumberService;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.stereotype.Service;

@Service
public class IsPhoneNumberServiceImp implements IsPhoneNumberService {
    @Override
    public boolean isPhoneNumber(String msisdn, String CountryId) {
        boolean ok=false;
        try{
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phone = phoneNumberUtil.parse(msisdn,
                    CountryId);
            ok = phoneNumberUtil.isPossibleNumberForType(phone, PhoneNumberUtil.PhoneNumberType.MOBILE);
        }catch (Exception e){
            return false;
        }

        return ok;
    }
}
