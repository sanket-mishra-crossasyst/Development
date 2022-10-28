package com.crossasyst.kafkaproducer.controller;

import com.crossasyst.kafkaproducer.service.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class KafkaController {
    @Autowired
    private TopicProducer topicProducer;

    @RequestMapping(value = "/kafka")
    public ResponseEntity<Void> send() {
        topicProducer.send("Mensagem de teste enviada ao tópico");
        return ResponseEntity.ok().build();
    }
}
