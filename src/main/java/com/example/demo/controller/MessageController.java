package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import com.example.demo.service.MessageConsumer;
import com.example.demo.service.MessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageProducer producer;
    private final MessageConsumer consumer;

    public MessageController(MessageProducer producer, MessageConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping
    public Map<String, String> sendMessage(@RequestBody Map<String, String> body) throws UnknownHostException {
        String message = body.get("message");
        String hostname = InetAddress.getLocalHost().getHostName();
        producer.sendMessage(message);
        return Map.of(
                "status", "sent",
                "sentBy", hostname,
                "message", message
        );
    }

    @GetMapping
    public Map<String, Object> getMessages() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        List<String> messages = consumer.getReceivedMessages();
        return Map.of(
                "server", hostname,
                "receivedMessages", messages
        );
    }
}
