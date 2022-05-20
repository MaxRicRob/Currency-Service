package com.example.Currency.Service.service;

import com.example.Currency.Service.dto.CurrencyRequest;
import com.example.Currency.Service.dto.CurrencyResponse;

public class CurrencyService {


    public CurrencyResponse getUpdatedCurrency(CurrencyRequest currencyRequest) {

        return new CurrencyResponse()
                .setId(currencyRequest.getId())
                .setUpdatedCurrency(currencyRequest.getWantedCurrency())
                .setUpdatedPrice((long) updatePrice(currencyRequest));


    }

    private double updatePrice(CurrencyRequest currencyRequest) {

        long totalPrice = currencyRequest.getTotalPrice();
        return switch (currencyRequest.getWantedCurrency()){
            case EURO -> totalPrice;
            case MXN -> totalPrice * 22;
            case USD -> totalPrice * 1.1;
            case CAD -> totalPrice * 1.4;
            case YEN -> totalPrice * 135;
            case POUND -> totalPrice * 0.9;
        };
    }
}
