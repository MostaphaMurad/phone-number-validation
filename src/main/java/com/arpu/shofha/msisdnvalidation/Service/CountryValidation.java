package com.arpu.shofha.msisdnvalidation.Service;

import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionResponseV2;
import com.google.i18n.phonenumbers.NumberParseException;

public interface CountryValidation {
     MsisdnRegionResponseV2 CountryValidationService(String countryName,String msisdn) throws NumberParseException;

}
