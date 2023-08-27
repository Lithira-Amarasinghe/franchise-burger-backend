package com.example.paymentservice.controller;


import com.example.paymentservice.model.PaymentIntentRequest;
import com.example.paymentservice.service.PaymentIntentService;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/paymentIntent")
public class PaymentIntentController {
    @Autowired
    private PaymentIntentService paymentIntentService;

    @PostMapping
    public ResponseEntity createPaymentIntent(@RequestBody PaymentIntentRequest paymentIntentRequest) {
        PaymentIntent paymentIntent = paymentIntentService.createPaymentIntent(paymentIntentRequest);
        return ResponseEntity.ok(paymentIntent.toJson());
    }
}
