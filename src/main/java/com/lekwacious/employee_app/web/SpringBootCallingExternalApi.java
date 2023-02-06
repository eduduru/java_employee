package com.lekwacious.employee_app.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class SpringBootCallingExternalApi {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping(value = "/callclienthello")
    private String getHelloClient(){
        String url = "http://localhost:8081/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping(value = "/countries")
    public List<Object> getCountries() {
        String url = "https://restcountries.eu/rest/v2/all";
        RestTemplate restTemplate = new RestTemplate();
        Object[] countries = restTemplate.getForObject(url, Object[].class);
        return  Arrays.asList(countries);
    }
}
