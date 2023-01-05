package com.arpu.shofha.msisdnvalidation.Controllers;

import com.arpu.shofha.msisdnvalidation.Service.Imp.MsisdnValidationServiceImp;
import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionRequestV2;
import com.arpu.shofha.msisdnvalidation.dto.MsisdnRegionResponseV2;
import com.google.i18n.phonenumbers.NumberParseException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v2/valid-msisdn")
@RequiredArgsConstructor
public class MsisdnApiValidation {
    Logger logger= LoggerFactory.getLogger(MsisdnApiValidation.class);
    private final MsisdnValidationServiceImp msisdnValidationServiceImp;
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MsisdnRegionResponseV2>isMsisdnValidV2(@RequestBody MsisdnRegionRequestV2 msisdnRegionRequestV2, HttpServletRequest request) throws NumberParseException {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        logger.trace("ip address "+ipAddress);
        return new ResponseEntity<>(msisdnValidationServiceImp.isMsisdnValid(msisdnRegionRequestV2,ipAddress), HttpStatus.OK);
    }
}
