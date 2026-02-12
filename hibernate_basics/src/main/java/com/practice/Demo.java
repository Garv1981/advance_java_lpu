package com.practice;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class Demo {
	public static void main(String []args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		
		//entity transaction
		EntityTransaction et = em.getTransaction();
		
		
//		Student s = new Student();
//		s.setId(2);
//		s.setName("rana");
//		s.setPercentage(80);
//		
//		et.begin();
//		em.persist(s);
//		et.commit();
//		
//		emf.close();
		
		// delete 
//		Student student = em.find(Student.class, 1);
//		et.begin();
//		em.remove(student);
//		et.commit();
//		
//		emf.close();
		
		//update
		Student student = em.find(Student.class, 2);
		if(student != null) {
			student.setName("bittu");
			et.begin();
			em.merge(student);
			et.commit();
			emf.close();
		}
	}
}
