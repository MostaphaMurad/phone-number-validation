package com.arpu.shofha.msisdnvalidation.dto;

import lombok.Data;

@Data
public class MsisdnRegionResponseV2 {
    private String operator;
    private String operatorCode;
    private String country;
    private String msisdn;
    private String message;
    private Integer status;
    private String pattern;
}
