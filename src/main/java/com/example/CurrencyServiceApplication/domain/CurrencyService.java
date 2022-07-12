package com.example.CurrencyServiceApplication.domain;

import com.example.CurrencyServiceApplication.api.error.ErrorResponseException;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {


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
            case POUND:
                return (long) (totalPrice * 0.9);
            default:
                return totalPrice;
        }
    }
}
