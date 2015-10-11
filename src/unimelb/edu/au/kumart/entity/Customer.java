package unimelb.edu.au.kumart.entity;

import java.util.List;

public class Customer extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String postAddress;
	private String phoneNumber;
	private List<ShoppingCart> shoppingCarts;

	public Customer() {
		super();
	}
	
	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
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
