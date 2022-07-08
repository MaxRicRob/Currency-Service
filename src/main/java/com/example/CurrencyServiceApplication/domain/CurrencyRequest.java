package com.example.CurrencyServiceApplication.domain;


import com.example.CurrencyServiceApplication.entity.Currency;
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
