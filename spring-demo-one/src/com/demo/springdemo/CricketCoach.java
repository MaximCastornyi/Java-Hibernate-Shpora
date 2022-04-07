package com.demo.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	
	@Value("${foo.emailAddress}")
	private String emailAddress;
	
	private String team;
	
	public CricketCoach() {
		System.out.println("Cricket Coach is running");
	}
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket Coach inside method set EMAIL Address");
		this.emailAddress = emailAddress;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("Cricket Coach inside method set TEAM");
		this.team = team;
	}



	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach inside method");
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast ball for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
