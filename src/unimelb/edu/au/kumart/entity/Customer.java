package unimelb.edu.au.kumart.entity;

import java.util.List;

public class Customer extends User{
	
	private String postAddress;
	private String phoneNumber;

	public Customer() {
		super();
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
