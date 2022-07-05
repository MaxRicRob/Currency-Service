package com.example.CurrencyServiceApplication.api;

import com.example.CurrencyServiceApplication.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.entity.CurrencyResponse;
import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;

public class RabbitController {


    @Autowired
    private CurrencyService currencyService;

    @RabbitListener(queues = "${queue-names.currency-service}")
    public String handleRequest(Message message) {

        var type = message.getMessageProperties().getType();
        if (type.equals("currencyRequest")) {
            var currencyRequest = new Gson().fromJson(
                    new String(message.getBody(), StandardCharsets.UTF_8), CurrencyRequest.class
            );
            return new Gson().toJson(currencyService.getUpdatedCurrency(currencyRequest));
        }
        return new Gson().toJson(new CurrencyResponse());
    }

}
