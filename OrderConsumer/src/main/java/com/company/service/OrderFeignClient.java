package com.company.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "OrderServer")
public interface OrderFeignClient {

    @GetMapping ("server/hello")
    String hello();
}
