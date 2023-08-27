package com.example.paymentservice.controller;


import com.example.paymentservice.model.PaymentProcessRequest;
import com.example.paymentservice.model.Response;
import com.example.paymentservice.service.TerminalPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/terminal/payments")
public class TerminalPaymentController {
    @Autowired
    private TerminalPaymentService terminalPaymentService;

    public Response processPayment(@RequestBody PaymentProcessRequest paymentProcessRequest) {
        terminalPaymentService.processPayment(paymentProcessRequest);
        return new Response();
    }
}
