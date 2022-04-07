package com.demo.springdemo;

public class TrackCoach implements Coach {


	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return " Just do it !!!!!!!!!!!!!!!!" + fortuneService.getFortune();
	}
	
	public void doMyStrartupStuff() {
		System.out.println("Starting Bean Method");
	}

	public void doMyCleanupStuff() {
		System.out.println("Destroying Bean Method");
	}

}
