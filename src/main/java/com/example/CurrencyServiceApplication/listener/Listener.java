package com.example.CurrencyServiceApplication.listener;

import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.example.CurrencyServiceApplication.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.error.ErrorResponseException;
import com.example.CurrencyServiceApplication.listener.dto.CurrencyResponse;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;

import static com.example.CurrencyServiceApplication.listener.MessageType.CURRENCY_REQUEST;

public class Listener {


    @Autowired
    private CurrencyService currencyService;

    @RabbitListener(queues = "${queue-names.currency-service}")
    public String handleRequest(Message message) {

        final MessageType messageType;
        try {
            messageType = MessageType.valueOf(message.getMessageProperties().getType());
        } catch (IllegalArgumentException e) {
            return errorResponse();
        }

        if (messageType.equals(CURRENCY_REQUEST)) {
            var currencyRequest = new Gson().fromJson(
                    new String(message.getBody(), StandardCharsets.UTF_8), CurrencyRequest.class
            );
            try {
                return new Gson().toJson(
                        CurrencyResponse.from(
                                currencyService.updateTotalPrice(currencyRequest)
                        )
                );
            } catch (ErrorResponseException e) {
                return errorResponse();
            }
        }
        return errorResponse();
    }

    private String errorResponse() {
        return "errorResponse";
    }

}
