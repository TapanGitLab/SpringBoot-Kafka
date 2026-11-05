package dev.danvega.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);

    private final KafkaTemplate<String, String> template;

    public MessageProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void send(String message) {
        // send() is asynchronous; the callback runs when the broker acknowledges (or fails)
        template.send("greetings", message).whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Send failed", ex);
            } else {
                var md = result.getRecordMetadata();
                log.info("Sent '{}' -> partition={} offset={}", message.substring(message.length()-5, message.length()), md.partition(), md.offset());
            }
        });
    }
}
