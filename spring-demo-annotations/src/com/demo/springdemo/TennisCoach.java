package com.demo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Component("person")
@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	//@Qualifier("happyFortuneService")
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
    */
	
	public TennisCoach() {
		System.out.println("....Tennis coach default constructor");
	}
	
	//@PreDestroy
	public void doMyStartupStuff() {
		System.out.println(">>> Tennis coach: inside");
	}
	
	
	/*
	//setter injection
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">>>>>>>>>>Tennis coach setter method");
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	//method injection
	@Autowired
	public void doFortuneService(FortuneService theFortuneService) {
		System.out.println(">>>>>>>>>>Tennis coach method");
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice yor backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
