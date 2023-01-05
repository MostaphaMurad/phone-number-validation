package com.arpu.shofha.msisdnvalidation.Service.Imp;

import com.arpu.shofha.msisdnvalidation.Service.CountryValidation;
import com.arpu.shofha.msisdnvalidation.StaticData.CountriesData;
import com.arpu.shofha.msisdnvalidation.dto.*;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MsisdnValidationServiceImp {
    private final CountryDetectionServiceImp countryDetectionServiceImp;
    private final IsPhoneNumberServiceImp isPhoneNumberServiceImp;
    public MsisdnRegionResponseV2 isMsisdnValid(MsisdnRegionRequestV2 msisdnRegionRequestV2,String ipAddress) throws NumberParseException {
        CountryValidation validationService;
        MsisdnRegionResponseV2 msisdnRegionResponseV2;
        CountriesData countriesData=new CountriesData();
        String country=countryDetectionServiceImp.getCountryNameByIpAddress(ipAddress);
        if(country.equals("Egypt")){
            validationService=new EgyptValidationServiceImplementation(countriesData,isPhoneNumberServiceImp);
            msisdnRegionResponseV2=validationService.CountryValidationService(country,msisdnRegionRequestV2.getMsisdn());
            return msisdnRegionResponseV2;
        }else{
            validationService=new CountriesValidationServiceImplementation(countriesData,isPhoneNumberServiceImp);
            msisdnRegionResponseV2=validationService.CountryValidationService(country,msisdnRegionRequestV2.getMsisdn());
            return msisdnRegionResponseV2;
        }

    }
}
