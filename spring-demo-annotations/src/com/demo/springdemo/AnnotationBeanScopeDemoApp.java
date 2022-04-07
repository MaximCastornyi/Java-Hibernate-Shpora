package com.demo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		System.out.println("Pointing to the same object: "+ result);
		System.out.println("Memory 4 Coach: "+ theCoach);
		System.out.println("Memory 4 alphaCoach: "+ theCoach);
		context.close();
	}

}
