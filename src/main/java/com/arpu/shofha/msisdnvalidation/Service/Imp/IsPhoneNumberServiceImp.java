package com.arpu.shofha.msisdnvalidation.Service.Imp;

import com.arpu.shofha.msisdnvalidation.Service.IsPhoneNumberService;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IsPhoneNumberServiceImp implements IsPhoneNumberService {
    Logger logger= LoggerFactory.getLogger(IsPhoneNumberServiceImp.class);
    @Override
    public boolean isPhoneNumber(String msisdn, String countryId) {
        boolean ok=false;
        try{
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phone = phoneNumberUtil.parse(msisdn,
                    countryId);
            ok = phoneNumberUtil.isPossibleNumberForType(phone, PhoneNumberUtil.PhoneNumberType.MOBILE);
            return ok;
        }catch (Exception e){
            logger.error("Invalid msisdn in IsPhoneNumberService "+msisdn+" country " +countryId);
            return false;
        }
    }
}
