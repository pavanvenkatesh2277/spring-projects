package com.hexaware.springcoredemo;

import org.springframework.stereotype.Component;


public class Car implements Vehicle {
	@Override
	public void move() {
		System.out.println("Car is moving");
	}

}