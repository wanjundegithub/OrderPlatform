package com.company.service.impl;

import com.company.dao.OrderDao;
import com.company.model.Order;
import com.company.service.OrderService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    @Caching(evict = {@CacheEvict(cacheNames = "orderList",allEntries = true)},
            put = {@CachePut(cacheNames = "order",key = "#order.orderId")})
    public boolean addOrder(Order order) {
        return orderDao.insertOrder(order)==1;
    }

    @Override
    @Caching(evict = {@CacheEvict(cacheNames = "orderList",allEntries = true),
            @CacheEvict(cacheNames = "order",key = "#orderId")})
    public boolean deleteOrder(Integer orderId) {
        return orderDao.deleteOrderByOrderId(orderId)==1;
    }

    @Override
    @Cacheable(value = "orderList")
    public List<Order> getAllOrders() {
        return orderDao.selectOrders();
    }

    @Override
    @Cacheable(value = "order")
    public Order getOrderById(Integer orderId) {
        return orderDao.selectOrderById(orderId);
    }

    @Override
    @Caching(evict = {@CacheEvict(cacheNames = "orderList",allEntries = true)},
            put = {@CachePut(cacheNames = "order",key = "#order.orderId")})
    public boolean updateOrder(Order order) {
        if(order.getOrderId()==null){
            return false;
        }
        return orderDao.updateOrder(order, order.getOrderId())==1;
    }
}
