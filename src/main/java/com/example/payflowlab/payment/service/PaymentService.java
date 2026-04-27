package com.example.payflowlab.payment.service;

import com.example.payflowlab.payment.dto.PaymentRequest;
import com.example.payflowlab.payment.dto.PaymentResponse;


public interface PaymentService {

	PaymentResponse requestPayment(PaymentRequest request);
}
