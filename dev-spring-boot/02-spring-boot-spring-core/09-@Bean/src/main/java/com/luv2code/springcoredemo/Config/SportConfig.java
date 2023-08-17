package com.luv2code.springcoredemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;


@Configuration     //YAPILANDIRMA İŞLEMİ İÇİN KOYULDU
public class SportConfig  {

		@Bean
		public  Coach SwimCoach() {
			return new SwimCoach();
		}
	
}
