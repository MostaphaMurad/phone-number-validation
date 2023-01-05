package com.arpu.shofha.msisdnvalidation.dto;

import lombok.Data;

import java.util.List;

@Data
public class CountryResponse {
    private String countryCode;
    private String country;
    private List<Object>operatorCode;
}
