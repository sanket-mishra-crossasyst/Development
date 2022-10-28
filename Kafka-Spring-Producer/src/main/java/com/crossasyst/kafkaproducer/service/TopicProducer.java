package com.crossasyst.kafkaproducer.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TopicProducer {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void send(String message) {
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
