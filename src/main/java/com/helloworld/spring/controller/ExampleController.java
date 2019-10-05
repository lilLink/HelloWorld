package com.helloworld.spring.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ExampleController {

    @RequestMapping("/")
    String home(){
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(ExampleController.class, args);
    }

}
