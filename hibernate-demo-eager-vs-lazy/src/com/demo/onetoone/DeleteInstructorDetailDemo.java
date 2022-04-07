package com.demo.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

            //get instructor detail object
			int theId = 4;
			
			InstructorDetail tempInstructorDetails = session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail " + tempInstructorDetails);
			System.out.println("the associated instructor  " + tempInstructorDetails.getInstructor());
			
			//deleting
			System.out.println("Deleting " + tempInstructorDetails);
			
			//remove bidirectional link
			tempInstructorDetails.getInstructor().setInstructorDetail(null);
			
			//deleting
			session.delete(tempInstructorDetails);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

