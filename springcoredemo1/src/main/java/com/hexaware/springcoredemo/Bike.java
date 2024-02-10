package com.hexaware.springcoredemo;

import org.springframework.stereotype.Component;

@Component("bike")
public class Bike implements Vehicle {
	
	public void move() {
	System.out.println("Bike is moving");

}
}