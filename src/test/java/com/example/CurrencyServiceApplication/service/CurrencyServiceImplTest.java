package com.example.CurrencyServiceApplication.service;

import com.example.CurrencyServiceApplication.domain.impl.CurrencyServiceImpl;
import com.example.CurrencyServiceApplication.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.error.ErrorResponseException;
import org.junit.jupiter.api.Test;

import static com.example.CurrencyServiceApplication.entity.Currency.CAD;
import static com.example.CurrencyServiceApplication.entity.Currency.MXN;
import static com.example.CurrencyServiceApplication.entity.Currency.PND;
import static com.example.CurrencyServiceApplication.entity.Currency.USD;
import static com.example.CurrencyServiceApplication.entity.Currency.YEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class CurrencyServiceImplTest {

    private final CurrencyServiceImpl currencyServiceImpl = new CurrencyServiceImpl();

    @Test
    void get_updated_currency_USD() {

        try {
            var currencyRequest = new CurrencyRequest()
                    .setTotalPrice(100)
                    .setWantedCurrency(USD);

            var response = currencyServiceImpl.updateTotalPrice(currencyRequest);

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

            var response = currencyServiceImpl.updateTotalPrice(currencyRequest);

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

            var response = currencyServiceImpl.updateTotalPrice(currencyRequest);

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

            var response = currencyServiceImpl.updateTotalPrice(currencyRequest);

            assertThat(response.getWantedCurrency()).isEqualTo(YEN);
            assertThat(response.getTotalPrice()).isEqualTo(13500);
        } catch (ErrorResponseException e) {
            fail();
        }
    }

    @Test
    void get_updated_currency_PND() {

        try {
            var currencyRequest = new CurrencyRequest()
                    .setTotalPrice(100)
                    .setWantedCurrency(PND);

            var response = currencyServiceImpl.updateTotalPrice(currencyRequest);

            assertThat(response.getWantedCurrency()).isEqualTo(PND);
            assertThat(response.getTotalPrice()).isEqualTo(90);
        } catch (ErrorResponseException e) {
            fail();
        }
    }
}
