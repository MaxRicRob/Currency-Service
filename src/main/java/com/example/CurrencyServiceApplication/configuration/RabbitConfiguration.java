package com.example.CurrencyServiceApplication.configuration;

import com.example.CurrencyServiceApplication.api.RabbitController;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfiguration {

    @Value("${xchange.name}")
    private String directXchangeName;

    @Value("${routing-keys.currency-service}")
    private String currencyServiceRoutingKey;

    @Value("${queue-names.currency-service}")
    private String currencyServiceQueueName;


    @Bean
    public RabbitController rabbitController() {
        return new RabbitController();
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directXchangeName);
    }

    @Bean
    public Queue currencyServiceQueue() {
        return new Queue(currencyServiceQueueName);
    }

    @Bean
    public Binding currencyServiceBinding(DirectExchange directExchange, Queue currencyServiceQueue) {
        return BindingBuilder.bind(currencyServiceQueue).to(directExchange).with(currencyServiceRoutingKey);
    }


}
