package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
	
	public BaseballCoach() {
		System.out.println("In Constructor:" + getClass().getSimpleName());
	}

	@Override
	@Autowired
	public String getDailyWorkout() {
		return "30dk dakika blablba yap";
	}

}
