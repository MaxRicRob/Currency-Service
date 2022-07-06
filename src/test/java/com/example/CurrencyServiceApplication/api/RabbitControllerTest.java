package com.example.CurrencyServiceApplication.api;

import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.example.CurrencyServiceApplication.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.entity.CurrencyResponse;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.Message;

import static com.example.CurrencyServiceApplication.entity.Currency.MXN;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RabbitControllerTest {

    @InjectMocks
    RabbitController rabbitController;

    @Mock
    CurrencyService currencyService;

    @Test
    void handleRequestWithCorrectMessageType() {
        var currencyRequest = getCurrencyRequest();
        var currencyResponse = getCurrencyResponse();
        var message = new Message((new Gson().toJson(currencyRequest)).getBytes());
        message.getMessageProperties()
                .setType("currencyRequest");
        when(currencyService.getUpdatedCurrency(any())).thenReturn(currencyResponse);

        rabbitController.handleRequest(message);

        verify(currencyService, times(1)).getUpdatedCurrency(any(CurrencyRequest.class));
    }

    @Test
    void handleRequestWithIncorrectMessageType() {
        var currencyRequest = getCurrencyRequest();
        var message = new Message((new Gson().toJson(currencyRequest)).getBytes());
        message.getMessageProperties()
                .setType("IncorrectMessageType");

        rabbitController.handleRequest(message);

        verifyNoInteractions(currencyService);
    }

    private CurrencyResponse getCurrencyResponse() {
        return new CurrencyResponse()
                .setId(1)
                .setUpdatedCurrency(MXN)
                .setUpdatedPrice(500L);
    }

    private CurrencyRequest getCurrencyRequest() {
        return new CurrencyRequest()
                .setId(1)
                .setWantedCurrency(MXN)
                .setTotalPrice(200L);
    }
}

