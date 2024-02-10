package com.hexaware.springcoredemo;

import org.springframework.stereotype.Component;

@Component("cycle")
public class Cycle implements Vehicle {
	public void move() {
		System.out.println("Cycle is moving");
	}

}