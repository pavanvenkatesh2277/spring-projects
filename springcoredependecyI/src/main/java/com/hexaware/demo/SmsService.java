package com.hexaware.demo;

import org.springframework.stereotype.Component;

@Component("smsService")
public class SmsService implements MessageService{
	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("Sending Sms :"+message);
		
	}
	
	

	

}