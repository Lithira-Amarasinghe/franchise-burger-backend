package com.example.paymentservice.controller;


import com.example.paymentservice.model.PaymentProcessRequest;
import com.example.paymentservice.service.TerminalPaymentService;
import com.stripe.model.terminal.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/terminal/payment")
public class TerminalPaymentController {
    @Autowired
    private TerminalPaymentService terminalPaymentService;

    @PostMapping("/process")
    public ResponseEntity processPayment(@RequestBody PaymentProcessRequest paymentProcessRequest) {
        Reader reader = terminalPaymentService.processPayment(paymentProcessRequest);
        return ResponseEntity.status(200).body(reader.toJson());
    }
}
