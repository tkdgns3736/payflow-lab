package com.example.payflowlab.payment.dto;

public class PaymentResponse {

    private Long paymentId;
    private String orderId;
    private String status;
    private String message;

    public PaymentResponse(Long paymentId, String orderId, String status, String message) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.status = status;
        this.message = message;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}