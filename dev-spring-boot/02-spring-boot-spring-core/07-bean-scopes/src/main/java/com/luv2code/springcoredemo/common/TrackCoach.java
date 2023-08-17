package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
	public TrackCoach() {
		System.out.println("In Constructor:" + getClass().getSimpleName());
	}
	
	public String getDailyWorkout() {
		return"40dk şapşup yap";
	}

}
