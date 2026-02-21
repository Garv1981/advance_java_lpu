package com.prac;
import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;
	private String city;
	private String state;
	private String pincode;
	
	public Address(long address_id, String city, String state, String pincode) {
		this.address_id = address_id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public long getAddress_id() {
		return address_id;
	}


	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	
}
