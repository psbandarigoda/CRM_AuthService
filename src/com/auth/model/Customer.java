package com.auth.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer extends User {
	
	private String firstName;
	private String lastName;
	private String NIC;
	private String address;

	
	public Customer() {
		super();
	}

	public Customer(Integer iD, String type, String email, String password, String contactNo, String firstName,
			String lastName, String nIC, String address) {
		super(iD, type, email, password, contactNo);
		this.firstName = firstName;
		this.lastName = lastName;
		NIC = nIC;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", NIC=" + NIC + ", address=" + address
				+ "]";
	}

}
