package com.auth.model;

public class CarOwner extends User {
	
	private String firstName;
	private String lastName;
	private String NIC;
	private String address;
	private String regNo;
	private String model;
	
	public CarOwner() {
		super();
	}
	
	public CarOwner(Integer iD, String type, String email, String password, String contactNo, String firstName, String lastName, String nIC, String address, String regNo, String model) {
		super(iD, type, email, password, contactNo);
		this.firstName = firstName;
		this.lastName = lastName;
		NIC = nIC;
		this.address = address;
		this.regNo = regNo;
		this.model = model;
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

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", NIC=" + NIC + ", address=" + address
				+ ", regNo= " + regNo + ", model= " + model + "]";
	}

}
