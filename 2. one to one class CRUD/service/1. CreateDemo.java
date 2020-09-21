package com.yin4learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yin4learn.hibernate.demo.entity.Instructor;
import com.yin4learn.hibernate.demo.entity.InstructorDetail;
import com.yin4learn.hibernate.demo.entity.Student;

public class CreateDemo {

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
			
			// create the objects
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"https://www.youtube.com/watch?v=GAd4ItXHBVE&ab_channel=DopeLyrics",
							"cooking");		
			
			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"https://www.youtube.com/watch?v=GAd4ItXHBVE&ab_channel=DopeLyrics",
							"Guitar");		
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//second object
			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"https://www.youtube.com/watch?v=GAd4ItXHBVE&ab_channel=DopeLyrics",
							"Guitar");		
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





