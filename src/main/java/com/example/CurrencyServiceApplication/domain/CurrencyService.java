package com.example.CurrencyServiceApplication.domain;

import com.example.CurrencyServiceApplication.domain.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.error.ErrorResponseException;

public interface CurrencyService {

    CurrencyRequest updateTotalPrice(CurrencyRequest currencyRequest) throws ErrorResponseException;
}
