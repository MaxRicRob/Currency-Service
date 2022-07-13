package com.example.CurrencyServiceApplication.api;

import com.example.CurrencyServiceApplication.domain.CurrencyService;
import com.example.CurrencyServiceApplication.domain.entity.CurrencyRequest;
import com.example.CurrencyServiceApplication.error.ErrorResponseException;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.Message;

import static com.example.CurrencyServiceApplication.api.MessageType.CURRENCY_REQUEST;
import static com.example.CurrencyServiceApplication.domain.Currency.MXN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RabbitControllerTest {

    @InjectMocks
    private RabbitController rabbitController;
    @Mock
    private CurrencyService currencyService;

    @Test
    void handle_request_with_correct_message_type() {

        try {
            var currencyRequest = getCurrencyRequest();
            var message = new Message((new Gson().toJson(currencyRequest)).getBytes());
            message.getMessageProperties()
                    .setType(CURRENCY_REQUEST.name());
            when(currencyService.updateTotalPrice(any())).thenReturn(currencyRequest);

            rabbitController.handleRequest(message);

            verify(currencyService).updateTotalPrice(any(CurrencyRequest.class));

        } catch (ErrorResponseException e) {
            fail();
        }
    }

    @Test
    void handle_request_with_incorrect_message_type() {
        var currencyRequest = getCurrencyRequest();
        var message = new Message((new Gson().toJson(currencyRequest)).getBytes());
        message.getMessageProperties()
                .setType("IncorrectMessageType");

        rabbitController.handleRequest(message);

        verifyNoInteractions(currencyService);
    }

    @Test
    void handle_request_catch_exception() {
        try {

            var currencyRequest = getCurrencyRequest();
            var message = new Message((new Gson().toJson(currencyRequest)).getBytes());
            message.getMessageProperties()
                    .setType(CURRENCY_REQUEST.name());
            when(currencyService.updateTotalPrice(any())).thenThrow(ErrorResponseException.class);

            var response = rabbitController.handleRequest(message);

            assertThat(response).isEqualTo("errorResponse");

        } catch (ErrorResponseException e) {
            fail();
        }
    }

    private CurrencyRequest getCurrencyRequest() {
        return new CurrencyRequest()
                .setWantedCurrency(MXN)
                .setTotalPrice(200L);
    }
}

