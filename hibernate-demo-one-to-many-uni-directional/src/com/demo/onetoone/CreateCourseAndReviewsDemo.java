package com.demo.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Review;


public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			

			// start a transaction
			session.beginTransaction();
						
            //create a course
			Course tempCourse = new Course("Pacman - how to Score");
			//add some reviews
			tempCourse.addReview(new Review("Creat course ... loved it"));
			tempCourse.addReview(new Review("Karate"));
			tempCourse.addReview(new Review("Kukuruza"));

			//save the course ... and leverage the cascade all 
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}




