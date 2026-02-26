package com.prac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="Stud")
public class Student {
	
	@Id
	private int studentId;
	private String name;
	private String email;
	private String branch;
	
	@OneToOne
	private Adhar_Card ac ;
	@OneToOne
	private Hostel_Room hr ;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Adhar_Card getAc() {
		return ac;
	}
	public void setAc(Adhar_Card ac) {
		this.ac = ac;
	}
	public Hostel_Room getHr() {
		return hr;
	}
	public void setHr(Hostel_Room hr) {
		this.hr = hr;
	}
	
	
}