package com.binary_beasts.binary_banking.accounts_api.service;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.param.ChargeCreateParams;

import java.util.HashMap;
import java.util.Map;
import com.stripe.Stripe;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
public class StripeService {



        public Customer createCustomer(String email) {
            Stripe.apiKey = "sk_test_..."; // Set your secret API key here

            CustomerCreateParams params = CustomerCreateParams.builder()
                    .setEmail(email)
                    .build();

            Customer customer = null;
            try {
                customer = Customer.create(params);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return customer;
        }

    public Charge createCharge(String token, int amount) {

        Stripe.apiKey = "sk_test_..."; // Set your secret API key here

        ChargeCreateParams params = ChargeCreateParams.builder()
                .setAmount((long) amount)
                .setCurrency("usd")
                .setDescription("Transfer")
                .setSource(token)
                .build();

        Charge charge = null;
        try {
            charge = Charge.create(params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return charge;
    }
}