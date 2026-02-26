package com.prac;
import javax.persistence.*;

public class DoctorDAO {
	private EntityManager em;
	
	public DoctorDAO(EntityManager em) {
		this.em = em;
	}
	
	public void saveDoctor(Doctor doctor) {
		em.getTransaction().begin();
		em.persist(doctor);
		em.getTransaction().commit();
	}
	
	public Doctor findDoctor(int id) {
		return em.find(Doctor.class, id);
	}
}
