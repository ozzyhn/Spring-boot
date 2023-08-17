package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//Propertiesleri bu kısımda enjekte ediyoruz
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}") // application properties kısmında vermiş oldugumuz isim ile eşleştiriyoruz
	private String teamName;
	
	//Heni bir endpoint ekleyecegiz
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach:" +coachName +",Team Name:"+teamName;
	}
	
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello World";

	
	}
	@GetMapping("/workout")
	public String workout() {
		
		return "EZGİGGG";

	
	}

}
