package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component //Enjeksiyon için hzır hale getirmek için kullanılır
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "15 dakika hızlı bowling calıs";
	}

}
