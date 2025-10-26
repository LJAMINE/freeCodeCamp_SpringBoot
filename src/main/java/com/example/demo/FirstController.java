package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello from my first controller";
    }

    @PostMapping("/post")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public String post(
         @RequestBody String message
    ) {
        return "accepted post and message " + message;
    }



    @PostMapping("/post-order")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public String post(
            @RequestBody Order order
    ) {
        return "accepted post and message " + order.toString();
    }

}
