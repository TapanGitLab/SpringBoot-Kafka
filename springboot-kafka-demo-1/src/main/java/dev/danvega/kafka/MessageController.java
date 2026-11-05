package dev.danvega.kafka;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageProducer producer;

    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/messages")
    public String send(@RequestParam String message) {
        producer.send(message);
        System.out.println("message sent to producer to push it to TOPIC ");
        return "accepted: " + message;
    }
}
