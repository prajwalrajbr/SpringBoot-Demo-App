package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private final List<String> receivedMessages = new CopyOnWriteArrayList<>();
    private final String hostname;

    public MessageConsumer() throws UnknownHostException {
        this.hostname = InetAddress.getLocalHost().getHostName();
    }

    @KafkaListener(topics = "demo-messages")
    public void listen(String message) {
        String entry = "[" + hostname + "] Received: " + message;
        receivedMessages.add(entry);
        System.out.println(entry);
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }
}
