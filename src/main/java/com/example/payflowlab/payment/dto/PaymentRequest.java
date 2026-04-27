package com.example.payflowlab.payment.dto;

public class PaymentRequest {

    private String userId;
    private Long amount;
    private String orderId;

    public String getUserId() {
        return userId;
    }

    public Long getAmount() {
        return amount;
    }

    public String getOrderId() {
        return orderId;
    }
}