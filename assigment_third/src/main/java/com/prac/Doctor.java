package com.prac;
import java.util.List;

import javax.persistence.*;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String specialization;
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public String getSpecialization() {
		return specialization;
	}

	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment>appointment;
	
}
