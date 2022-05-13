package com.company.dao;

import com.company.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    Order selectOrderById(Integer orderId);
}
