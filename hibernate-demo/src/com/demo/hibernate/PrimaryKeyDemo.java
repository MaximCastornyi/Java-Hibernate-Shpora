package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			// create 3 student object
			System.out.println("Object created");
			Student tempStudent1 = new Student("John", "God", "kuku@kuku.com");
			Student tempStudent2 = new Student("Mark", "God", "kuku@kuku.com");
			Student tempStudent3 = new Student("Bonita", "God", "kuku@kuku.com");
			// start transaction
			session.beginTransaction();
			// save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
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
