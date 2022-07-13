package com.example.CurrencyServiceApplication.service;

import com.example.CurrencyServiceApplication.error.ErrorResponseException;
import com.example.CurrencyServiceApplication.domain.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.example.CurrencyServiceApplication.domain.Currency;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class CurrencyServiceTest {

    @Test
    void get_updated_currency() {

        try {
            final CurrencyService currencyService = new CurrencyService();

            var currencyRequest = currencyService.updateTotalPrice(getCurrencyRequest());

            assertThat(currencyRequest.getWantedCurrency()).isEqualTo(Currency.USD);
            assertThat(currencyRequest.getTotalPrice()).isEqualTo(110);

        } catch (ErrorResponseException e) {
            fail();
        }
    }

    private CurrencyRequest getCurrencyRequest() {

        return new CurrencyRequest()
                .setWantedCurrency(Currency.USD)
                .setTotalPrice(100);
    }
}
