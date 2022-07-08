package com.example.CurrencyServiceApplication.service;

import com.example.CurrencyServiceApplication.domain.CurrencyRequest;
import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.example.CurrencyServiceApplication.entity.Currency;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyServiceTest {

    @Test
    void get_updated_currency() {

        final CurrencyService currencyService = new CurrencyService();

        var currencyRequest = currencyService.updateTotalPrice(getCurrencyRequest());

        assertThat(currencyRequest.getWantedCurrency()).isEqualTo(Currency.USD);
        assertThat(currencyRequest.getTotalPrice()).isEqualTo(110);
    }

    private CurrencyRequest getCurrencyRequest() {

        return new CurrencyRequest()
                .setWantedCurrency(Currency.USD)
                .setTotalPrice(100);
    }
}
