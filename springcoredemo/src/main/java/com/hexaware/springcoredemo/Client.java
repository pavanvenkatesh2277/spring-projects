package com.hexaware.springcoredemo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[]args) {
	 //Vehicle t = new Car();
	//Traveller obj=new Traveller(t);
	//obj.startJourney();
	AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);
	Car obj=applicationContext.getBean(Car.class);
	obj.move();
	//Bike obj1=applicationContext.getBean(Bike.class);
	//obj.move();
	}

}