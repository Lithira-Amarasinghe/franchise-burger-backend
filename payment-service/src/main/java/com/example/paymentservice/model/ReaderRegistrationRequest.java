package com.example.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReaderRegistrationRequest {
    private String registrationCode;
    private String label;
    private String locationId;
}
