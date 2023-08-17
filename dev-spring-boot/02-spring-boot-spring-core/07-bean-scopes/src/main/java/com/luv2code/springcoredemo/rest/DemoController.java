package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

@RestController
public class DemoController {
	//Bagımlılıklarımız için özel bir enjeksiyon yapacagız
	private Coach myCoach;
	private Coach anotherCoach;
	
	@Autowired
	public DemoController
	(@Qualifier("cricketCoach")Coach theanotherCoach,
	 @Qualifier("cricketCoach")Coach theCoach) {
		System.out.println("In Constructor:" + getClass().getSimpleName());
		myCoach = theCoach;
		anotherCoach= theanotherCoach;
	}
	
	
	@GetMapping("/check")
	public String check() {
		System.out.println("derlenen nesneler: myCoach==AnotherCoach:" + (myCoach== anotherCoach));
		// EĞER BELLEKTE AYNI BEANE GÖRE OLUŞTURULDULARSA TRUE DEĞERİ ALIRIZ
		//FALSE DEĞERİ ALIRSAK PROTOTYPE YAPISINA GÖRE FARKLI BEANLERDE OLUŞMUŞLARDIR
		return null;
	}
	
	@GetMapping("/dailyworkout")  //  sitemize /dailyworkout yazılarak bu metoda ve döndürdüğü değerlere ulaşılabilir
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
