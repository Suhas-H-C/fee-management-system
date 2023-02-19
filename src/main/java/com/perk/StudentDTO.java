package com.perk;

import lombok.Data;

@Data
public class StudentDTO {

	private int id;
	private String firstname;
	private String lastname;
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", feepaid=" + feepaid + ", feedue=" + feedue + ", address=" + address + "]";
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
