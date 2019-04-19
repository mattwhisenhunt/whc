package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ChallengeController {

    @Autowired
    WindService serv;

    @RequestMapping(value="/api/v1/wind/{zip}", produces={"application/json"})
    public String wind(@PathVariable("zip") String zip) {

        // validate ZIP code
        char[] charArr = zip.toCharArray();
        for (char c : charArr) {
            if(!(Character.isDigit(c) || c == '-')) {
                DemoApplication.log.warn("Non-digital zipcode.");
                return "";
            }
        }
		
		// Try to accommodate extended ZIP+4 input 
		if ( charArr[ zip.length() - 5] == '-') {
			zip = zip.substring(0, zip.length() - 5);
		}

        if (zip.length() > 5) {
            DemoApplication.log.warn("Zipcode too large.");
            return "";
        }
        if (zip.length() == 4) {
            DemoApplication.log.info("Zipcode may be abbreviated.");
            zip = "0" + zip;
        }

        String json = "";
        Wind w = serv.getByZipCode(zip);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(w);
        } catch (JsonProcessingException e) {
            // e.printStackTrace();
        }
        return json;
    }
}
