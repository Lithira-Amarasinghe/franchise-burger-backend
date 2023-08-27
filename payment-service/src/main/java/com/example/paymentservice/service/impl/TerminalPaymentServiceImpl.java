package com.example.paymentservice.service.impl;

import com.example.paymentservice.model.PaymentIntentRequest;
import com.example.paymentservice.model.PaymentProcessRequest;
import com.example.paymentservice.service.PaymentIntentService;
import com.example.paymentservice.service.TerminalPaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.terminal.Reader;
import com.stripe.param.terminal.ReaderProcessPaymentIntentParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TerminalPaymentServiceImpl implements TerminalPaymentService {
    @Value("${stripe.apiKey}")
    private String STRIPE_API_KEY;

    @Autowired
    private PaymentIntentService paymentIntentService;

    public Reader processPayment(PaymentProcessRequest paymentProcessRequest) {
        Stripe.apiKey = STRIPE_API_KEY;

        PaymentIntentRequest paymentIntentRequest = PaymentIntentRequest.builder()
                .paymentMethod(paymentProcessRequest.getPaymentMethod())
                .amount(paymentProcessRequest.getAmount())
                .currency(paymentProcessRequest.getCurrency())
                .email(paymentProcessRequest.getEmail())
                .build();

        PaymentIntent paymentIntent = paymentIntentService.createPaymentIntent(paymentIntentRequest);

        System.out.println(paymentIntent.getId());
        Reader resource = null;
        try {
            resource = Reader.retrieve(paymentProcessRequest.getTerminalId());
            ReaderProcessPaymentIntentParams params =
                    ReaderProcessPaymentIntentParams.builder().setPaymentIntent(paymentIntent.getId()).build();
            Reader reader = resource.processPaymentIntent(params);
            return reader;
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
