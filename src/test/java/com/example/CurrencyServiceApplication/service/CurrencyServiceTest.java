package com.example.CurrencyServiceApplication.service;

import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.example.CurrencyServiceApplication.domain.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.error.ErrorResponseException;
import org.junit.jupiter.api.Test;

import static com.example.CurrencyServiceApplication.domain.Currency.CAD;
import static com.example.CurrencyServiceApplication.domain.Currency.MXN;
import static com.example.CurrencyServiceApplication.domain.Currency.POUND;
import static com.example.CurrencyServiceApplication.domain.Currency.USD;
import static com.example.CurrencyServiceApplication.domain.Currency.YEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class CurrencyServiceTest {

    private final CurrencyService currencyService = new CurrencyService();

    @Test
    void get_updated_currency_USD() {

        try {
            var currencyRequest = new CurrencyRequest()
                    .setTotalPrice(100)
                    .setWantedCurrency(USD);

            var response = currencyService.updateTotalPrice(currencyRequest);

            assertThat(response.getWantedCurrency()).isEqualTo(USD);
            assertThat(response.getTotalPrice()).isEqualTo(110);
        } catch (ErrorResponseException e) {
            fail();
        }
    }

    @Test
    void get_updated_currency_MXN() {

        try {
            var currencyRequest = new CurrencyRequest()
                    .setTotalPrice(100)
                    .setWantedCurrency(MXN);

            var response = currencyService.updateTotalPrice(currencyRequest);

            assertThat(response.getWantedCurrency()).isEqualTo(MXN);
            assertThat(response.getTotalPrice()).isEqualTo(2200);
        } catch (ErrorResponseException e) {
            fail();
        }
    }

    @Test
    void get_updated_currency_CAD() {

        try {
            var currencyRequest = new CurrencyRequest()
                    .setTotalPrice(100)
                    .setWantedCurrency(CAD);

            var response = currencyService.updateTotalPrice(currencyRequest);

            assertThat(response.getWantedCurrency()).isEqualTo(CAD);
            assertThat(response.getTotalPrice()).isEqualTo(140);
        } catch (ErrorResponseException e) {
            fail();
        }
    }

    @Test
    void get_updated_currency_YEN() {

        try {
            var currencyRequest = new CurrencyRequest()
                    .setTotalPrice(100)
                    .setWantedCurrency(YEN);

            var response = currencyService.updateTotalPrice(currencyRequest);

            assertThat(response.getWantedCurrency()).isEqualTo(YEN);
            assertThat(response.getTotalPrice()).isEqualTo(13500);
        } catch (ErrorResponseException e) {
            fail();
        }
    }

    @Test
    void get_updated_currency_POUND() {

        try {
            var currencyRequest = new CurrencyRequest()
                    .setTotalPrice(100)
                    .setWantedCurrency(POUND);

            var response = currencyService.updateTotalPrice(currencyRequest);

            assertThat(response.getWantedCurrency()).isEqualTo(POUND);
            assertThat(response.getTotalPrice()).isEqualTo(90);
        } catch (ErrorResponseException e) {
            fail();
        }
    }
}
