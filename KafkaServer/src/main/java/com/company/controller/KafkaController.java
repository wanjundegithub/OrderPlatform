package com.company.controller;

import com.company.config.KafkaSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Resource
    private KafkaSender kafkaSender;

    @GetMapping("/sendMsg/{msg}")
    private void sendMessage(@PathVariable("msg") String msg){
        kafkaSender.send(msg);
    }
}
