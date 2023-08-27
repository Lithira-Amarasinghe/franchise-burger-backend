package com.example.paymentservice.service.impl;

import com.example.paymentservice.service.TappingCardSimulateService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.terminal.Reader;
import com.stripe.param.terminal.ReaderPresentPaymentMethodParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TappingCardSimulateServiceImpl implements TappingCardSimulateService {
    @Value("${STRIPE_API_KEY}")
    private String STRIPE_API_KEY;

    @Override
    public Reader tapACard(String terminalId) {
        try {
            Stripe.apiKey = STRIPE_API_KEY;

        Reader resource = Reader.retrieve(terminalId);

        ReaderPresentPaymentMethodParams params =
                ReaderPresentPaymentMethodParams.builder().build();

            return resource.getTestHelpers().presentPaymentMethod(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
