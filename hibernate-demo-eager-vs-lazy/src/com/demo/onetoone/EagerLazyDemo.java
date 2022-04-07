package com.demo.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			

			// start a transaction
			session.beginTransaction();
						
			//get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//get course for the instructor
			System.out.println("Instructor " + tempInstructor);
			
			System.out.println("Courses " + tempInstructor.getCourses());
			// commit transaction
			session.getTransaction().commit();
			
			//Close the session for lazy
			session.close();
			
			//To retrieve lazy data you need to create Hibernate session - option1
			
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}




