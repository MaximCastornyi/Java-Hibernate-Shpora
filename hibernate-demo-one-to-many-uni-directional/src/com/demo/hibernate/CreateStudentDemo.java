package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			// create a student object
			System.out.println("Object created");
			Student tempStudent = new Student("Max", "God", "kuku@kuku.com");
			// start transaction
			session.beginTransaction();
			// save the student object
			session.save(tempStudent);
			System.out.println("Object saved");
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
