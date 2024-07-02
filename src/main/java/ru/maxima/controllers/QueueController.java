package ru.maxima.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class QueueController {
    private final AmqpTemplate amqpTemplate;

@Autowired
    public QueueController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @PostMapping("/ack")
    public ResponseEntity<String> ack(@RequestBody String message){
        System.out.println(message);
            amqpTemplate.convertAndSend("myFirstQueue", message);
            return ResponseEntity.ok("Successful sending: "+ message);

    }
}
