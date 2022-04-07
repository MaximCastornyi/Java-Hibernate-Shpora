package com.demo.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coach theCoachBassball = new BaseballCoach(null);
		Coach theCoachTrack = new TrackCoach(null);
		System.out.println(theCoachBassball.getDailyWorkout());
		System.out.println(theCoachTrack.getDailyWorkout());
	}

}
