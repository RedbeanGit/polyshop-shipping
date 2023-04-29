package fr.dopolytech.polyshop.shipping.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dopolytech.polyshop.shipping.models.PolyshopEvent;

@Service
public class QueueService {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    public QueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendShippingSuccess(PolyshopEvent event) throws JsonProcessingException {
        String message = this.stringify(event);
        rabbitTemplate.convertAndSend("shippingExchange", "shipping.success", message);
    }

    public void sendShippingFailed(PolyshopEvent event) throws JsonProcessingException {
        String message = this.stringify(event);
        rabbitTemplate.convertAndSend("shippingExchange", "shipping.failed", message);
    }

    public String stringify(PolyshopEvent data) throws JsonProcessingException {
        return mapper.writeValueAsString(data);
    }

    public PolyshopEvent parse(String data) throws JsonProcessingException {
        return mapper.readValue(data, PolyshopEvent.class);
    }
}
