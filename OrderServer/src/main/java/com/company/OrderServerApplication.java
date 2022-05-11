package com.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.company.dao")
public class OrderServerApplication {
    public static void main(String[] args){
        SpringApplication.run(OrderServerApplication.class,args);
    }
}
