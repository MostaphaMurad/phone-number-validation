package com.arpu.shofha.msisdnvalidation.Service.Imp;

import com.arpu.shofha.msisdnvalidation.Controllers.MsisdnApiValidation;
import com.arpu.shofha.msisdnvalidation.Service.CountryValidation;
import com.arpu.shofha.msisdnvalidation.StaticData.CountriesData;
import com.arpu.shofha.msisdnvalidation.dto.HasPrefix;
import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionResponseV2;
import com.arpu.shofha.msisdnvalidation.dto.OperatorResponse;
import com.google.i18n.phonenumbers.NumberParseException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class EgyptValidationServiceImplementation implements CountryValidation {
    public final CountriesData countriesData;
    public final IsPhoneNumberServiceImp isPhoneNumberServiceImp;
    @Override
    public MsisdnRegionResponseV2 CountryValidationService(String countryName, String msisdn) throws NumberParseException {
        Logger logger= LoggerFactory.getLogger(MsisdnApiValidation.class);
        logger.info("msisdn "+msisdn+" country "+countryName);
        MsisdnRegionResponseV2 msisdnRegionResponseV2=new MsisdnRegionResponseV2();
        msisdn=countriesData.convertToEnglishDigits(msisdn);
        msisdn=msisdn.replaceAll("[^a-zA-Z0-9]", "");

        HasPrefix hasPrefix=countriesData.hasPrefixForCountry(countryName,msisdn);

        if(msisdn.length()<10){
            msisdnRegionResponseV2.setStatus(0);
            msisdnRegionResponseV2.setMsisdn(msisdn);
            msisdnRegionResponseV2.setCountry(countryName);
            msisdnRegionResponseV2.setMessage("Invalid Mobile Number ");
            msisdnRegionResponseV2.setPattern(hasPrefix.getMsisdnPattern());
            logger.error("Invalid msisdn "+msisdn+" country "+countryName);
            return msisdnRegionResponseV2;
        }

        int idx=0,cntz=0;
        if(msisdn.startsWith("2")){
            idx++;
            while(msisdn.charAt(idx)=='0') {
                cntz++;
                idx++;
            }
            if(cntz>1){
                msisdn=msisdn.substring(cntz+1);
                msisdn="20"+msisdn;
            }
        }
        else{
            while(msisdn.charAt(idx)=='0'){
                cntz++;
                idx++;
            }
            msisdn=msisdn.substring(cntz);
            msisdn="20"+msisdn;
        }
        logger.info("msisdn after format "+msisdn+" country "+countryName);
        boolean okPhone=isPhoneNumberServiceImp.isPhoneNumber(msisdn,hasPrefix.getCountryId());
        String prefix_4=msisdn.substring(0,4);
        List<String >prefixes=new ArrayList<>();
        prefixes.add(prefix_4);
        OperatorResponse operatorResponse=countriesData.operatorData(prefixes);
        if(okPhone&&operatorResponse!=null&&operatorResponse.getCountry().equals(countryName)){
            msisdnRegionResponseV2.setStatus(1);
            msisdnRegionResponseV2.setMsisdn(msisdn);
            msisdnRegionResponseV2.setCountry(countryName);
            msisdnRegionResponseV2.setPattern(msisdn);
            msisdnRegionResponseV2.setOperator(operatorResponse.getOperatorName());
            msisdnRegionResponseV2.setOperatorCode(operatorResponse.getOperatorCode());
            msisdnRegionResponseV2.setMessage("Correct Mobile Number ");
            logger.info("Correct msisdn "+msisdn+" country "+countryName);

        }else{
            msisdnRegionResponseV2.setStatus(0);
            msisdnRegionResponseV2.setCountry(countryName);
            msisdnRegionResponseV2.setMsisdn(msisdn);
            msisdnRegionResponseV2.setPattern(hasPrefix.getMsisdnPattern()==null? operatorResponse.getMsisdnPattern() : hasPrefix.getMsisdnPattern());
            msisdnRegionResponseV2.setOperator(operatorResponse.getOperatorName());
            msisdnRegionResponseV2.setOperatorCode(operatorResponse.getOperatorCode());
            msisdnRegionResponseV2.setMessage("Invalid Mobile Number ");
            logger.error("Wrong msisdn "+msisdn+" country "+countryName);
        }
        return msisdnRegionResponseV2;
    }

}
