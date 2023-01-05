package com.arpu.shofha.msisdnvalidation.Service.Imp;

import com.arpu.shofha.msisdnvalidation.Controllers.MsisdnApiValidation;
import com.arpu.shofha.msisdnvalidation.Service.CountryValidation;
import com.arpu.shofha.msisdnvalidation.Service.Imp.IsPhoneNumberServiceImp;
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
public class CountriesValidationServiceImplementation implements CountryValidation {
    public final CountriesData countriesData;
    public final IsPhoneNumberServiceImp isPhoneNumberServiceImp;
    @Override
    public MsisdnRegionResponseV2 CountryValidationService(String countryName, String msisdn) {
        Logger logger= LoggerFactory.getLogger(MsisdnApiValidation.class);
        logger.info("msisdn "+msisdn+" country "+countryName);
        boolean removePrefix=false;
        MsisdnRegionResponseV2 msisdnRegionResponseV2=new MsisdnRegionResponseV2();
        msisdn=countriesData.convertToEnglishDigits(msisdn);
        msisdn=msisdn.replaceFirst("^0+(?!$)","");
        msisdn=msisdn.replaceAll("[^a-zA-Z0-9]", "");
        msisdn=msisdn.replaceFirst("^0+(?!$)","");
        HasPrefix hasPrefix=countriesData.hasPrefixForCountry(countryName,msisdn);
        if(!msisdn.startsWith(hasPrefix.getCountryCode())){
            if(msisdn.length()>hasPrefix.getMsisdnLen()){
                int dif=0;
                while(msisdn.charAt(dif)=='0')
                    dif++;
                msisdn=msisdn.substring(dif);
            }
            if(!msisdn.startsWith(hasPrefix.getCountryCode()))
                msisdn=hasPrefix.getCountryCode()+msisdn;
        }
        else {
            msisdn=msisdn.substring(hasPrefix.getCountryCode().length());
            int dif=0;
            while(msisdn.charAt(dif)=='0')
                dif++;
            msisdn=msisdn.substring(dif);
            msisdn=hasPrefix.getCountryCode()+msisdn;
        }
        if(msisdn.startsWith(hasPrefix.getCountryCode())){
            msisdn=msisdn.substring(hasPrefix.getCountryCode().length());
            removePrefix=true;
        }
        logger.info("msisdn after format "+msisdn+" country "+countryName);
        boolean ok=isPhoneNumberServiceImp.isPhoneNumber(msisdn,hasPrefix.getCountryId());
        if(removePrefix)
            msisdn=hasPrefix.getCountryCode()+msisdn;
        String prefix_3=msisdn.substring(0,3);
        String prefix_4=msisdn.substring(0,4);
        String prefix_5=msisdn.substring(0,5);
        List<String >prefixes=new ArrayList<>();
        prefixes.add(prefix_3);
        prefixes.add(prefix_4);
        prefixes.add(prefix_5);
        OperatorResponse operatorResponse=countriesData.operatorData(prefixes);
        if(!hasPrefix.getCountryCode().equals(operatorResponse.getCountryCode())){
            msisdnRegionResponseV2.setStatus(0);
            msisdnRegionResponseV2.setMsisdn(msisdn);
            msisdnRegionResponseV2.setCountry(countryName);
            msisdnRegionResponseV2.setOperator(operatorResponse.getOperatorName());
            msisdnRegionResponseV2.setOperatorCode(operatorResponse.getOperatorCode());
            msisdnRegionResponseV2.setPattern(operatorResponse.getMsisdnPattern()==null? hasPrefix.getMsisdnPattern() : operatorResponse.getMsisdnPattern());
            msisdnRegionResponseV2.setMessage("Invalid Mobile Number ");
            logger.error("Invalid msisdn "+msisdn+" country "+countryName);

            return msisdnRegionResponseV2;
        }
        if(ok==true&&operatorResponse!=null&&operatorResponse.getOperatorCode()!=null&&(operatorResponse.getCountry().equals(countryName))){
            msisdnRegionResponseV2.setStatus(1);
            msisdnRegionResponseV2.setMsisdn(msisdn);
            msisdnRegionResponseV2.setCountry(countryName);
            msisdnRegionResponseV2.setOperator(operatorResponse.getOperatorName());
            msisdnRegionResponseV2.setOperatorCode(operatorResponse.getOperatorCode());
            msisdnRegionResponseV2.setMessage("Correct Mobile Number ");
            logger.info("Correct msisdn "+msisdn+" country "+countryName);

            msisdnRegionResponseV2.setPattern(msisdn);
        }else{
            msisdnRegionResponseV2.setStatus(0);
            msisdnRegionResponseV2.setMsisdn(msisdn);
            msisdnRegionResponseV2.setCountry(countryName);
            msisdnRegionResponseV2.setOperator(operatorResponse.getOperatorName());
            msisdnRegionResponseV2.setOperatorCode(operatorResponse.getOperatorCode());
            msisdnRegionResponseV2.setPattern(operatorResponse.getMsisdnPattern()==null? hasPrefix.getMsisdnPattern() : operatorResponse.getMsisdnPattern());
            msisdnRegionResponseV2.setMessage("Invalid Mobile Number ");
            logger.error("Invalid msisdn "+msisdn+" country "+countryName);

        }
        return msisdnRegionResponseV2;
    }
}
