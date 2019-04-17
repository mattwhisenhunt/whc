package com.example.demo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WindService
{
    final String PATH  = "https://api.openweathermap.org/data/2.5/weather?zip=";
    final String APPID = "&APPID=bc611040aa17619b4c72b3fb9a850425";

    @Cacheable("wind")
    public Wind getByZipCode(String zip)
    {
        Weather weather = new RestTemplate()
                .getForObject(PATH + zip + APPID, Weather.class);

        Wind w = new Wind(
                weather.getWind().getSpeed(), weather.getWind().getDeg());

        DemoApplication.log.info("Uncached: " + w);
        return w;
    }
}
