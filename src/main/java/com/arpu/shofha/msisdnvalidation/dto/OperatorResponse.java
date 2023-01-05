package com.arpu.shofha.msisdnvalidation.dto;

import lombok.Data;

@Data
public class OperatorResponse {
    private String country;
    private String operatorCode;
    private String countryCode;
    private String operatorName;
    private String msisdnPattern;
}
