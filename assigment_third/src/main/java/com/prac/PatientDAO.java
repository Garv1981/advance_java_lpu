package com.prac;
import javax.persistence.*;


public class PatientDAO {
		private EntityManager em;
		
		public PatientDAO(EntityManager em) {
			this.em = em;
		}
		
		public void savePatient(Patient patient) {
			em.getTransaction().begin();
			em.persist(patient);
			em.getTransaction().commit();
		}
		
		public Patient findPatient(int id) {
			return em.find(Patient.class, id);
		}
		
		public void updatePatient(Patient patient) {
			em.getTransaction().begin();
			em.merge(patient);
			em.getTransaction().commit();
		}
		public void deletePatient(int id) {
			em.getTransaction().begin();
			Patient p = em.find(Patient.class, id);
			if(p != null)em.remove(p);
			em.getTransaction().commit();
		}
}
