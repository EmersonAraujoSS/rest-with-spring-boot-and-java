package br.com.avancard.controllers;

import br.com.avancard.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeating(@RequestParam(value = "name", defaultValue = "Word") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
