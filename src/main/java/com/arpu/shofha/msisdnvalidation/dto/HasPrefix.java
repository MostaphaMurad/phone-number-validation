package com.arpu.shofha.msisdnvalidation.dto;

import lombok.Data;

@Data
public class HasPrefix {
    private String msisdn;
    private String countryCode;
    private String countryId;
    private Boolean hasPrefix;
    private Integer msisdnLen;
    private String msisdnPattern;
}
