package com.demo.springdemo;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
			"KUKU",
			"HAHA",
			"HIHI"
	};
	
	private Random myRandom = new Random();
	
	
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return null;
	}

}
