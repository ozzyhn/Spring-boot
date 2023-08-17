package com.luv2code.springcoredemo.common;


//Bean kullanacagımız için @component kullanmıyoruz enjekte için bean kullanılacak
public class SwimCoach implements Coach {
	
	//Tanılama ıcın oluşturuyruz
	public SwimCoach() {
		System.out.println("In Constructor:"+ getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "10 km yüz";
	}

}
