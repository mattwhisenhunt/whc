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

    @RequestMapping("/api/v1/wind/{zip}")
    public String wind(@PathVariable("zip") String zip) {
		// validate zipcode

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
