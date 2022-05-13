package com.company.controller;

import com.company.service.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class OrderController {

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        return orderFeignClient.hello();
    }

    @GetMapping("/rest1")
   public String get1(){
        String result=restTemplate.getForObject("http://127.0.0.1:9002/server/hello",String.class);
        return result;
   }

    @GetMapping("/rest3")
   public String get3(){
       String url=String.format("http://%s/server/hello","OrderServer");
       return restTemplate.getForObject(url,String.class);
   }
}
