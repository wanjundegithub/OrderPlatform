package com.company.dao;

import com.company.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    int insertOrder(Order order);

    int deleteOrderByOrderId(Integer id);

    List<Order> selectOrders();

    Order selectOrderById(Integer id);

    int updateOrder(@Param("pojo") Order order,@Param("orderId") Integer id);
}
