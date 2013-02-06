package com.krsoft.dataentry.model;

public class Person {

	private String name;
	private String socialSecurityNumber;
	private String address;
	private String telephone;

	public Person(String name, String socialSecurityNumber, String address,
			String telephone) {
		super();
		this.name = name;
		this.socialSecurityNumber = socialSecurityNumber;
		this.address = address;
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
