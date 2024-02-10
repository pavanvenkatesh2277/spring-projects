package com.hexaware.demo;

import org.springframework.stereotype.Component;

@Component("emailService")
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
    System.out.println("Sending email: " + message);
    }
}