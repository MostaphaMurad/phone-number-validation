package com.arpu.shofha.msisdnvalidation.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {
    @GetMapping("")
    public String test()  {
        return "Hello";
    }
}
