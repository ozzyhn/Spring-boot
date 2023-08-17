package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	public TennisCoach() {
		System.out.println("In Constructor:" + getClass().getSimpleName());
	}
	
	public String getDailyWorkout() {
		return "25dk bal bal yap";
	}



}
