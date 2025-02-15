package com.fikreynurz.microservices.order_service.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity) {
    public void placeOrder(OrderRequest orderRequest) {
    }
}
