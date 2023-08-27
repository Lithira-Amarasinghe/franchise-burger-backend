package com.example.paymentservice.service;

import com.stripe.model.terminal.Reader;
import org.springframework.stereotype.Service;

@Service
public interface TappingCardSimulateService {
    Reader tapACard(String terminalId);

}
