package com.example.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentProcessRequest {
    private Long amount;
    private String terminalId;
    private String currency;
    private String paymentMethod;
    private String email;
}
