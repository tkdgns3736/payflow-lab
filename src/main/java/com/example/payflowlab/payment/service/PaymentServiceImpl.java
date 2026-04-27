package com.example.payflowlab.payment.service;

import org.springframework.stereotype.Service;

import com.example.payflowlab.common.exception.BusinessException;
import com.example.payflowlab.payment.dto.PaymentRequest;
import com.example.payflowlab.payment.dto.PaymentResponse;
import com.example.payflowlab.payment.entity.Payment;
import com.example.payflowlab.payment.entity.PaymentStatus;
import com.example.payflowlab.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponse requestPayment(PaymentRequest request) {

        if (request.getUserId() == null || request.getUserId().isBlank()) {
            throw new BusinessException("사용자 아이디는 필수입니다.");
        }

        if (request.getOrderId() == null || request.getOrderId().isBlank()) {
            throw new BusinessException("주문번호는 필수입니다.");
        }

        if (request.getAmount() == null) {
            throw new BusinessException("결제 금액은 필수입니다.");
        }

        if (request.getAmount() <= 0) {
            throw new BusinessException("결제 금액은 0보다 커야 합니다.");
        }

        Payment payment = new Payment(
                request.getUserId(),
                request.getAmount(),
                request.getOrderId(),
                PaymentStatus.REQUESTED
        );

        Payment savedPayment = paymentRepository.save(payment);

        return new PaymentResponse(
                savedPayment.getId(),
                savedPayment.getOrderId(),
                savedPayment.getStatus().name(),
                "결제 요청이 저장되었습니다."
        );
    }
}