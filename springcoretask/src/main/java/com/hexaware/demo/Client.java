package com.hexaware.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
             EmailService service= (EmailService)context.getBean("emailservice");
             service.sendemail();
	}

}