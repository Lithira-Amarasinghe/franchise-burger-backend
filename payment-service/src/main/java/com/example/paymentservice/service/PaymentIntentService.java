package com.example.paymentservice.service;

import com.example.paymentservice.model.PaymentIntentRequest;
import com.example.paymentservice.model.PaymentProcessRequest;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Service;

@Service
public interface PaymentIntentService {
    PaymentIntent createPaymentIntent(PaymentIntentRequest paymentIntentRequest);
}
