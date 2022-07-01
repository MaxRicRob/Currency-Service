package com.example.CurrencyServiceApplication.service;

import com.example.CurrencyServiceApplication.dto.Currency;
import com.example.CurrencyServiceApplication.dto.CurrencyRequest;
import com.example.CurrencyServiceApplication.dto.CurrencyResponse;
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
