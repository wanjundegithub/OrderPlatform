package com.company.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class OrderController {

    @GetMapping("/hello")
    public String hello(){
        return "hello,world";
    }
}
