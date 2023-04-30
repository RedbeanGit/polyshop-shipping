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
    public TopicExchange orderExchange() {
        return new TopicExchange("orderExchange");
    }

    @Bean
    public Binding paymentDoneBinding(Queue startShippingQueue, TopicExchange exchange) {
        return BindingBuilder.bind(startShippingQueue).to(exchange).with("order.paid");
    }
}
