package com.nitin.demo.mainservice.controller;/**
 * @author : Nitin Jain
 * @mailto : official.nitinjain@gmail.com
 * @created : 6/5/2022, Sunday
 **/


import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 What this program snippet doing?
 **/
@RestController
public class MainServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainServiceController.class);

    @Autowired
    private RestTemplate restTemplate;

   @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/home")
    public String MainServiceHome(){
        LOGGER.info("This is Main Service Controller Homepage");
        return "This is Main Service Controller Homepage";

    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/sleuth")
    public ResponseEntity<String>  Test(){
        LOGGER.info("Sleuth Service is being called here");
        RestTemplate restTemplate = new RestTemplate();
        String sleuthResourceUrl
                = "http://localhost:8081/home";  //pointing to service1
        ResponseEntity<String> response
                = restTemplate.getForEntity(sleuthResourceUrl, String.class);

        return response;

    }

    @GetMapping("/getmainsleuthtest")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getMainSleuthTest(){

        LOGGER.info("I am here in main service calling service1");
        String response = restTemplate.getForObject("http://localhost:8081/serviceOne", String.class);

        return new ResponseEntity<String>(response,HttpStatus.OK);
    }


}
