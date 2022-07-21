package com.example.CurrencyServiceApplication.domain.impl;

import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.example.CurrencyServiceApplication.domain.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.error.ErrorResponseException;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {


    @Override
    public CurrencyRequest updateTotalPrice(CurrencyRequest currencyRequest) throws ErrorResponseException {

        if (currencyRequest == null) throw new ErrorResponseException();
        return currencyRequest
                .setTotalPrice(updatePrice(currencyRequest));
    }

    private long updatePrice(CurrencyRequest currencyRequest) {

        var totalPrice = currencyRequest.getTotalPrice();
        switch (currencyRequest.getWantedCurrency()) {
            case MXN:
                return totalPrice * 22;
            case USD:
                return (long) (totalPrice * 1.1);
            case CAD:
                return (long) (totalPrice * 1.4);
            case YEN:
                return totalPrice * 135;
            case PND:
                return (long) (totalPrice * 0.9);
            default:
                return totalPrice;
        }
    }
}
