package com.prac;
import javax.persistence.*;
import java.util.*;
public class HospitalService {
	private EntityManager em;
	private PatientDAO patientDAO;
	private DoctorDAO doctorDAO;
	private AppointmentDAO appointmentDAO;
	
	HospitalService(EntityManager em){
		this.em = em;
		patientDAO = new PatientDAO(em);
		patientDAO = new PatientDAO(em);
        doctorDAO = new DoctorDAO(em);
        appointmentDAO = new AppointmentDAO(em);
	}
	
	public void registerPatient(Patient p) {
		patientDAO.savePatient(p);
	}
	
	public void addAppointmentToDoctor(Doctor doctor , List<Appointment>appointments) {
		doctor.setAppointments(appointments);
		doctorDAO.saveDoctor(doctor);
	}
	  public void assignAppointmentToPatient(Appointment appt, Patient patient) {
	        appt.setPatient(patient);
	        appointmentDAO.saveAppointment(appt);
	    }
	  public void updateAppointmentFee(int id, double fee) {
	        appointmentDAO.updateFee(id, fee);
	    }

	    public Doctor fetchDoctor(int id) {
	        return doctorDAO.findDoctor(id);
	    }

	    public void deletePatient(int id) {
	        patientDAO.deletePatient(id);
	    }

}
