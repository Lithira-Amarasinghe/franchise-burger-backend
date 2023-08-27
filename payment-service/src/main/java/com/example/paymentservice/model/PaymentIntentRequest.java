package com.example.paymentservice.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PaymentIntentRequest {
    private Long amount;
    private String currency;
    private String paymentMethod;
    private String email;
}
