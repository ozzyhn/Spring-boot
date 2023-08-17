package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	//Bagımlılıklarımız için özel bir enjeksiyon yapacagız
	private Coach myCoach;
	
	//Conssturctoru bagımlılıga göre enjekte ediyoruz
	@Autowired //Autowired bagımlılık enjekte etmesini söyler
	public DemoController(Coach theCoach) {
		myCoach= theCoach;
	}
	
	@GetMapping("/dailyworkout")  //  sitemize /dailyworkout yazılarak bu metoda ve döndürdüğü değerlere ulaşılabilir
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
