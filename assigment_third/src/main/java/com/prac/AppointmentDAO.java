package com.prac;
import javax.persistence.*;
import java.util.*;

public class AppointmentDAO {
	private EntityManager em;
	
	public AppointmentDAO(EntityManager em) {
		this.em = em;
	}
	
	public void saveAppointment(Appointment apt) {
        em.getTransaction().begin();
        em.persist(apt);
        em.getTransaction().commit();
    }
	
	 public void updateFee(int id, double newFee) {
	        em.getTransaction().begin();
	        Appointment a = em.find(Appointment.class, id);
	        if (a != null) {
	            a.setFee(newFee);
	        }
	        em.getTransaction().commit();
	    }
	 
	 public List<Appointment> findAppointmentByDoctor(int doctorId) {
		    Doctor d = em.find(Doctor.class, doctorId);
		    return d.getAppointments();
		}
}
