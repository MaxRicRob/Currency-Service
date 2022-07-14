package com.example.CurrencyServiceApplication.listener.dto;


import com.example.CurrencyServiceApplication.domain.Currency;
import com.example.CurrencyServiceApplication.domain.entity.CurrencyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CurrencyResponse {

    private long totalPrice;
    private Currency wantedCurrency;

    public static CurrencyResponse from(CurrencyRequest currencyRequest) {
        return new CurrencyResponse()
                .setWantedCurrency(currencyRequest.getWantedCurrency())
                .setTotalPrice(currencyRequest.getTotalPrice());
    }
}
