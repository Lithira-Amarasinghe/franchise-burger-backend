package com.example.paymentservice.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.terminal.Reader;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.terminal.ReaderPresentPaymentMethodParams;
import com.stripe.param.terminal.ReaderProcessPaymentIntentParams;

public class ReaderConnection {
    public static void main(String args[]) throws StripeException {
//        pi_3NjbUTLJfluVTg0a1ZPgsI6S
//        tmr_FOUsYgm0t8MRhZ


        // Set your secret key. Remember to switch to your live secret key in production.
// See your keys here: https://dashboard.stripe.com/apikeys
//        Stripe.apiKey = "sk_test_51Nic2dLJfluVTg0aHqpKmjA7Y8SxySEOaDxrcTUxS49VZnO3rO9UlVSEsiPRwJCNygACyn0WCVFOmGTYpUf4BshT00lfRWpoHG";
//
//        PaymentIntentCreateParams params =
//                PaymentIntentCreateParams.builder()
//                        .setCurrency("usd")
//                        .addPaymentMethodType("card_present")
//                        .setCaptureMethod(PaymentIntentCreateParams.CaptureMethod.AUTOMATIC)
//                        .setAmount(1000L)
//                        .build();
//
//        PaymentIntent paymentIntent = PaymentIntent.create(params);


        // Set your secret key. Remember to switch to your live secret key in production.
// See your keys here: https://dashboard.stripe.com/apikeys
//        Stripe.apiKey = "sk_test_51Nic2dLJfluVTg0aHqpKmjA7Y8SxySEOaDxrcTUxS49VZnO3rO9UlVSEsiPRwJCNygACyn0WCVFOmGTYpUf4BshT00lfRWpoHG";
//
//        Reader resource = Reader.retrieve("tmr_FOUsYgm0t8MRhZ");
//
//        ReaderProcessPaymentIntentParams params =
//                ReaderProcessPaymentIntentParams.builder().setPaymentIntent("pi_3NjbUTLJfluVTg0a1ZPgsI6S").build();
//
//        Reader reader = resource.processPaymentIntent(params);
//

// Set your secret key. Remember to switch to your live secret key in production.
// See your keys here: https://dashboard.stripe.com/apikeys
        Stripe.apiKey = "sk_test_51Nic2dLJfluVTg0aHqpKmjA7Y8SxySEOaDxrcTUxS49VZnO3rO9UlVSEsiPRwJCNygACyn0WCVFOmGTYpUf4BshT00lfRWpoHG";

        Reader resource = Reader.retrieve("tmr_FOUsYgm0t8MRhZ");

        ReaderPresentPaymentMethodParams params =
                ReaderPresentPaymentMethodParams.builder().build();

        Reader reader = resource.getTestHelpers().presentPaymentMethod(params);

    }
}
