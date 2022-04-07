package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alfaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alfaCoach);
		System.out.println("\n Pointing to the same object: " + result);
		System.out.println("\n Memory location for theCoach" + alfaCoach);
		
		context.close();
	}

}
