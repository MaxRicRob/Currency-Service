package com.example.CurrencyServiceApplication.api;

import com.example.CurrencyServiceApplication.dto.CurrencyRequest;
import com.example.CurrencyServiceApplication.dto.CurrencyResponse;
import com.example.CurrencyServiceApplication.service.CurrencyService;
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

        var input = parseMessage(message);
        if (input[0].equals("currencyRequest")) {
            var currencyRequest = new Gson().fromJson(input[1], CurrencyRequest.class);
            return new Gson().toJson(currencyService.getUpdatedCurrency(currencyRequest));
        }
        return new Gson().toJson(new CurrencyResponse());
    }

    private String[] parseMessage(Message message) {
        return new String(message.getBody(), StandardCharsets.UTF_8).split("_");
    }
}
