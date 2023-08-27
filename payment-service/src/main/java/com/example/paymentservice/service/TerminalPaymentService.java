package com.example.paymentservice.service;

import com.example.paymentservice.model.PaymentIntentRequest;
import com.example.paymentservice.model.PaymentProcessRequest;
import com.stripe.model.terminal.Reader;
import org.springframework.stereotype.Service;

@Service
public interface TerminalPaymentService {
    Reader processPayment(PaymentProcessRequest paymentProcessRequest);
}
