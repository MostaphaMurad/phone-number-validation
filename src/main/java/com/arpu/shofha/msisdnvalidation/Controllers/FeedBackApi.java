package com.arpu.shofha.msisdnvalidation.Controllers;

import com.arpu.shofha.msisdnvalidation.Service.Imp.FeedbackServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Mostafa Murad
 * @created: 1/12/2023 on 10:22 AM
 **/
@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor
public class FeedBackApi {
    private final FeedbackServiceImp feedbackServiceImp;
    @PostMapping("")
    public ResponseEntity<String>feedback(@RequestParam String msisdn, @RequestParam String message){
        return new ResponseEntity<>(feedbackServiceImp.sendFeedback(msisdn,message), HttpStatus.OK);
    }
}
