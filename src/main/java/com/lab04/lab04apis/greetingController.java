package com.lab04.lab04apis;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class greetingController {
    private static final String template = "Hello, %s!";

    private final java.util.concurrent.atomic.AtomicLong count = new AtomicLong();

    //endpoint for responding to calls for /greeting 

    @GetMapping("/greeting")
    public Greeting Greeting() {
        return new Greeting(count.incrementAndGet(), String.format(template, "World"));


    }

    //endpoint for responding to calls for /greeting/name?name=YourName

    @GetMapping("/greeting/name")
    public Greeting Greeting(@RequestParam(value = "name", defaultValue = "ease") String name) {
        return new Greeting(count.incrementAndGet(), String.format(template, name));
    }    
    

}
