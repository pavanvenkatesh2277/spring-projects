package com.hexaware.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class MessageSender {
    private final MessageService messageService1;
    private final MessageService messageService2;

    @Autowired
    public MessageSender(@Qualifier("emailService") MessageService messageService1,
                         @Qualifier("smsService") MessageService messageService2) {
        this.messageService1 = messageService1;
        this.messageService2 = messageService2;
    }

    public void sendMessage(String m, String type) {
        if ("email".equals(type)) {
            this.messageService1.sendMessage(m);
        } else {
            this.messageService2.sendMessage(m);
        }
    }
}