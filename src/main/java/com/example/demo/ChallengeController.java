package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ChallengeController {

    @RequestMapping("/challenge/wind/{zip}")
    public String wind(@PathVariable("zip") String zip) {
        return "Greetings from Spring Boot!" + zip;
    }
}
