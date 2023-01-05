package com.arpu.shofha.msisdnvalidation.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MsisdnRegionResponse {
    private Integer status;
    private String country;
    private String message;
    private String msisdn;
    private String countryCode;
    private List<Object>operatorCode=new ArrayList<>();
}
