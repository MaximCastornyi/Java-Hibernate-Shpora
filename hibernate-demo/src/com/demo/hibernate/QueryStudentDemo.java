package com.demo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			// start transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").list();
					
			//display the students
			displayStudents(theStudents);
			
            //get student Max
			theStudents = session.createQuery("from Student where first_name='Mark'").list();
			
			//display the students
			System.out.println("Who is Mark");
			displayStudents(theStudents);
			
			
			//query where name is Duffy or Bonita
			theStudents = session.createQuery("from Student where first_name='Duffy' OR first_name='Bonita'").list();
			
			//display the students where name is Duffy or Bonita
			System.out.println("Who is Duffy or Bonita");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} finally {
			session.close();
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents)
		{
			System.out.println(tempStudent);
		}
	}

}
