/*
package com.arpu.shofha.msisdnvalidation.Controllers;

import com.arpu.shofha.msisdnvalidation.Service.Imp.MsisdnValidationServiceImp;
import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionResponse;
import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionRequest;
import com.google.i18n.phonenumbers.NumberParseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/valid-msisdn")
@RequiredArgsConstructor
public class MsisdnApi {
    private final MsisdnValidationServiceImp msisdnValidationServiceImp;
    @GetMapping("")
    public ResponseEntity<MsisdnRegionResponse>validateMsisdn(@RequestBody MsisdnRegionRequest msisdnRegionRequest) throws NumberParseException {
        return new ResponseEntity<>(msisdnValidationServiceImp.isMsisdnValid(msisdnRegionRequest), HttpStatus.OK);
    }

}
*/
