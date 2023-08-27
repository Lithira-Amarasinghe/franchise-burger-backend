package com.example.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentProcessRequest {
    private String terminalId;
    private String currency;
    private Long amount;
    private String paymentMethod;
    private String email;
}

