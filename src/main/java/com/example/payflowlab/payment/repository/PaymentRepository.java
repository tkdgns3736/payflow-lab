package com.example.payflowlab.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payflowlab.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}