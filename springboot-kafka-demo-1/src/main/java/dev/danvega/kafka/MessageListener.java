package dev.danvega.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    @KafkaListener(topics = "greetings", groupId = "demo_group_1")
    public void listen_1(String message) {
        log.info("got in listener-1 : {}", message.substring(message.length()-5, message.length()));
    }
    
    @KafkaListener(topics = "greetings", groupId = "demo_group_1")
    public void listen_2(String message) {
        log.info("got in listener-2 : {}", message.substring(message.length()-5, message.length()));
    }
    
    @KafkaListener(topics = "greetings", groupId = "demo_group_1")
    public void listen_3(String message) {
        log.info("got in listener-3 : {}", message.substring(message.length()-5, message.length()));
    }
    
    /*    
    @KafkaListener(topics = "greetings", groupId = "demo_group_1")
    public void listen_4(String message) {
        log.info("got in listener-4 : {}", message.substring(message.length()-5, message.length()));
    }
    
    @KafkaListener(topics = "greetings", groupId = "demo_group_1")
    public void listen_5(String message) {
        log.info("got in listener-5 : {}", message.substring(message.length()-5, message.length()));
    }
    
    @KafkaListener(topics = "greetings", groupId = "demo_group_1")
    public void listen_6(String message) {
        log.info("got in listener-6 : {}", message.substring(message.length()-5, message.length()));
    }
    */
}
