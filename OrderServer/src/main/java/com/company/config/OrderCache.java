package com.company.config;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

/**
 * 自定义缓存注解
 */
@Caching(put={@CachePut(cacheNames = "order",key = "#order.orderId"),
@CachePut(cacheNames = "order",key = "#order.userName")})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface  OrderCache {
}
