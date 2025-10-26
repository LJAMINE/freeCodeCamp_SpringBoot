package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

//    @GetMapping("/hello")
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



    @PostMapping("/post-order-record")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public String postRecord(
            @RequestBody Order order
    ) {
        return "accepted post and message " + order.toString();
    }

/// hello/ali
    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    ) {
        return "my value ="+userName;
    }


//    request param
///hello?param1=val&param2=val2
    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastName") String lastName

    ) {
        return "my value ="+userName+" "+lastName;
    }

}
