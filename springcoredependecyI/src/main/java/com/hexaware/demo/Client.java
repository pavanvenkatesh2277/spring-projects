package com.hexaware.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Client {
    public static void main(String[] args) {
        String message = "Hello world";

        // Create the IoC container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Using SMS to send message
        MessageSender sender = context.getBean(MessageSender.class);
        sender.sendMessage(message, "sms");

        // Using email to send message
        MessageService emailService = context.getBean(EmailService.class);
        MessageSender sender1 = new MessageSender(emailService, null);
        sender1.sendMessage(message, "email");
    }
}