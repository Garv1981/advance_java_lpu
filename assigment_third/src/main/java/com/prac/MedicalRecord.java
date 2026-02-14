package com.prac;
import javax.persistence.*;

@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bloodGroup;
	private String allergies;
	
}
