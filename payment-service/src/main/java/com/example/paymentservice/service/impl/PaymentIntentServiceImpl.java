package com.example.paymentservice.service.impl;

import com.example.paymentservice.model.PaymentIntentRequest;
import com.example.paymentservice.model.PaymentProcessRequest;
import com.example.paymentservice.service.PaymentIntentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentIntentServiceImpl implements PaymentIntentService {
    @Value("${STRIPE_API_KEY}")
    private String STRIPE_API_KEY;

    @Override
    public PaymentIntent createPaymentIntent(PaymentIntentRequest paymentIntentRequest) {
        Stripe.apiKey = STRIPE_API_KEY;
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setCurrency(paymentIntentRequest.getCurrency())
                        .addPaymentMethodType(paymentIntentRequest.getPaymentMethod())
                        .setCaptureMethod(PaymentIntentCreateParams.CaptureMethod.AUTOMATIC)
                        .setAmount(paymentIntentRequest.getAmount())
                        .setReceiptEmail(paymentIntentRequest.getEmail())
                        .build();

        try {
            return PaymentIntent.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
