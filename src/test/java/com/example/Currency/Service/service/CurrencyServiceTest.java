package com.example.Currency.Service.service;

import com.example.Currency.Service.dto.Currency;
import com.example.Currency.Service.dto.CurrencyRequest;
import com.example.Currency.Service.dto.CurrencyResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CurrencyServiceTest {



    @Test
    void getUpdatedCurrency() {

        final CurrencyService currencyService = new CurrencyService();

        final CurrencyResponse currencyResponse = currencyService.getUpdatedCurrency(getCurrencyRequest());

        assertThat(currencyResponse.getUpdatedCurrency()).isEqualTo(Currency.USD);
        assertThat(currencyResponse.getUpdatedPrice()).isEqualTo(110);
    }

    private CurrencyRequest getCurrencyRequest() {

        return new CurrencyRequest()
                .setId(1)
                .setWantedCurrency(Currency.USD)
                .setTotalPrice(100);
    }
}
