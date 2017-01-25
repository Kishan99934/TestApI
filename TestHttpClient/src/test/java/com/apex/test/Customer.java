package com.apex.test;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="CUSTOMER")
public class Customer {
	
	private int id;
	private String firstname;
	private String lastname;
	private String street;
	private String city;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	@XmlElement(name="ID")
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	
	@XmlElement(name="FIRSTNAME")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	@XmlElement(name="LASTNAME")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}
	@XmlElement(name="STREET")
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}
	@XmlElement(name="CITY")
	public void setCity(String city) {
		this.city = city;
	}
	

}
