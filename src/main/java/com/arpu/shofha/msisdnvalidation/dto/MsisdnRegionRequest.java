package com.arpu.shofha.msisdnvalidation.dto;

import lombok.Data;

@Data
public class MsisdnRegionRequest {
    private String msisdn;
    private String countryCode;
}
