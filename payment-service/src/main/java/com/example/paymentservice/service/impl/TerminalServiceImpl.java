package com.example.paymentservice.service.impl;

import com.example.paymentservice.model.ReaderRegistrationRequest;
import com.example.paymentservice.service.TerminalService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.terminal.Reader;
import com.stripe.model.terminal.ReaderCollection;
import com.stripe.param.terminal.ReaderCreateParams;
import com.stripe.param.terminal.ReaderListParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TerminalServiceImpl implements TerminalService {
    @Value("${stripe.apiKey}")
    private String STRIPE_API_KEY;

    @Override
    public ReaderCollection getAllReadersAt(String locationId) {
        Stripe.apiKey = STRIPE_API_KEY;
        ReaderListParams params =
                ReaderListParams.builder()
                        .build();

        try {
            return Reader.list(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reader registerTerminal(ReaderRegistrationRequest readerRegistrationRequest) {
        Stripe.apiKey = STRIPE_API_KEY;

        ReaderCreateParams params =
                ReaderCreateParams.builder()
                        .setRegistrationCode(readerRegistrationRequest.getRegistrationCode())
                        .setLabel(readerRegistrationRequest.getLabel())
                        .setLocation(readerRegistrationRequest.getLocationId())
                        .build();

        try {
            return Reader.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reader getReader(String terminalId) {
        Stripe.apiKey = STRIPE_API_KEY;
        try {
            return Reader.retrieve(terminalId);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
