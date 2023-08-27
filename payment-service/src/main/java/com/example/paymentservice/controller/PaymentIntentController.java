package com.example.paymentservice.controller;


import com.example.paymentservice.model.PaymentIntentRequest;
import com.example.paymentservice.model.Response;
import com.example.paymentservice.service.PaymentIntentService;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/paymentIntent")
public class PaymentIntentController {
    @Autowired
    private PaymentIntentService paymentIntentService;

    @PostMapping
    public Response<PaymentIntent> createPaymentIntent(@RequestBody PaymentIntentRequest paymentIntentRequest) {
        PaymentIntent paymentIntent = paymentIntentService.createPaymentIntent(paymentIntentRequest);
        return new Response<>(
                HttpStatus.OK,
                paymentIntent
        );
    }
}
