package com.example.CurrencyServiceApplication.service;

import com.example.CurrencyServiceApplication.dto.CurrencyRequest;
import com.example.CurrencyServiceApplication.dto.CurrencyResponse;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {


    public CurrencyResponse getUpdatedCurrency(CurrencyRequest currencyRequest) {

        return new CurrencyResponse()
                .setId(currencyRequest.getId())
                .setUpdatedCurrency(currencyRequest.getWantedCurrency())
                .setUpdatedPrice((long) updatePrice(currencyRequest));


    }

    private double updatePrice(CurrencyRequest currencyRequest) {

        long totalPrice = currencyRequest.getTotalPrice();
        switch (currencyRequest.getWantedCurrency()){
            case MXN: return totalPrice * 22;
            case USD: return totalPrice * 1.1;
            case CAD: return totalPrice * 1.4;
            case YEN: return totalPrice * 135;
            case POUND: return totalPrice * 0.9;
            default: return totalPrice;
        }
    }
}
