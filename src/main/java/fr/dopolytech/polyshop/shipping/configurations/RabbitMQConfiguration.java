package fr.dopolytech.polyshop.shipping.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public Queue startShippinghippingQueue() {
        return new Queue("startShippingQueue", true);
    }

    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange("paymentExchange");
    }

    @Bean
    public Binding paymentDoneBinding(Queue startShippingQueue, TopicExchange paymentExchange) {
        return BindingBuilder.bind(startShippingQueue).to(paymentExchange).with("payment.done.success");
    }
}
