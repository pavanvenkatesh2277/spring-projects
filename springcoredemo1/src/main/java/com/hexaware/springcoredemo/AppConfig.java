package com.hexaware.springcoredemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hexaware.springcoredemo")
public class AppConfig {
	//@Bean
	//public Vehicle returnCarObj() {
		//return new Car();
	//}
	//@Bean
	//public Vehicle returnBikeObj() {
		//return new Bike();
	//}
	//@Bean
	//public Vehicle returnCycleObj() {
		//return new Cycle();
	//}
	//@Bean
	//public Traveller returnTravellerObj() {
		//return new Traveller(returnBikeObj());//dependency injection
	///}

}
