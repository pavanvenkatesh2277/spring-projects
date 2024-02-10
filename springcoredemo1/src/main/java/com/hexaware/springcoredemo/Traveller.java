package com.hexaware.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("traveller")
public class Traveller {
	
//	 private Car carObj=null;
//	 private Bike BikeObj=null;
//	 private Cycle Obj=null;
	private Vehicle Obj=null;
	@Autowired

	//public Traveller(@Qualifier("car") Vehicle t) {
	public Traveller( Vehicle t) {	
		super();
		 this.Obj =  t;
	}
	 
	public void startJourney() {
		
	
	this.Obj.move();

}
}