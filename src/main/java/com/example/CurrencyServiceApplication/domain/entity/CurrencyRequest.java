package com.example.CurrencyServiceApplication.domain.entity;


import com.example.CurrencyServiceApplication.domain.Currency;
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
public class CurrencyRequest {

    private long totalPrice;
    private Currency wantedCurrency;

}
