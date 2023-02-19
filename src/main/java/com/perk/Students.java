package com.perk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private double feepaid;
	private double feedue;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public double getFeepaid() {
		return feepaid;
	}
	public void setFeepaid(double feepaid) {
		this.feepaid = feepaid;
	}
	public double getFeedue() {
		return feedue;
	}
	public void setFeedue(double feedue) {
		this.feedue = feedue;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Students(int id,String firstname, String lastname, int age,
			double feepaid, double feedue, String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.feepaid = feepaid;
		this.feedue = feedue;
		this.address = address;
	}
	public Students() {
		super();
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", Age=" + age
				+ ", feepaid=" + feepaid + ", feedue=" + feedue + ", address=" + address + "]";
	}
	

	
	
}
