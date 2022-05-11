package com.company.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -1340095119555693650L;

    private Integer orderId;

    private String userName;

    private BigDecimal priceNumber;

    private String orderDescription;
}
