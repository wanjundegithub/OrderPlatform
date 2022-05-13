package com.company.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Long orderId;

    private String orderName;

    private BigDecimal orderPrice;

    private String userName;

    private String orderDescription;
}
