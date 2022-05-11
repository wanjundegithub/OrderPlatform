package com.company.service;

import com.company.model.Order;

import java.util.List;

public interface OrderService {

    boolean addOrder(Order order);

    boolean deleteOrder(Integer orderId);

    List<Order> getAllOrders();

    Order getOrderById(Integer orderId);

    boolean updateOrder(Order order);
}
