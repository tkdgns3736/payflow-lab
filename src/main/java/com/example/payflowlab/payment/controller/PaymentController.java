package com.example.payflowlab.payment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payflowlab.payment.dto.PaymentRequest;
import com.example.payflowlab.payment.dto.PaymentResponse;
import com.example.payflowlab.payment.service.PaymentService;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public PaymentResponse requestPayment(@RequestBody PaymentRequest request) {
        return paymentService.requestPayment(request);
    }
}