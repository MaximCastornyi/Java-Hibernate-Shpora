package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
            int studentId = 1;
             
            session = factory.getCurrentSession();
            session.beginTransaction();
         
            //retrive student based on the id: primary key
            System.out.println("Getting student with id: " + studentId);
            
            Student myStudent = session.get(Student.class, studentId);
            
            //delete the student
            session.delete(myStudent);
            System.out.println("Cancelled!!!");
            
            //by HQL for one Id
            session.createQuery("delete from Student where id=2").executeUpdate();
            
            
			// commit transaction
			session.getTransaction().commit();
		
			System.out.println("Done!!!!");
		} finally {
			session.close();
			factory.close();
		}
	}

}