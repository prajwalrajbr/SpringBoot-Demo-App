package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        return "Hello World! Served by: " + hostname;
    }
}
