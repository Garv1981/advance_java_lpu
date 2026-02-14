package com.prac;
import javax.persistence.*;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	private MedicalRecord medical;
}
