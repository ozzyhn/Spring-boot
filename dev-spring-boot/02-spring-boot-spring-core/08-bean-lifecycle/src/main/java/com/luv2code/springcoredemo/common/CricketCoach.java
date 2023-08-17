package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component //Enjeksiyon için hzır hale getirmek için kullanılır
public class CricketCoach implements Coach {
	public CricketCoach() {
		System.out.println("In Constructor:" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {

		return "15 dakika hızlı bowling calıs";
	}

}
