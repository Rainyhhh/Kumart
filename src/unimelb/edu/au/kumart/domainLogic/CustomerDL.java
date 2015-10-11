package unimelb.edu.au.kumart.domainLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.Customer;
import unimelb.edu.au.kumart.entity.ShoppingCart;
import unimelb.edu.au.kumart.entity.User;
import unimelb.edu.au.kumart.mongodb.CustomerMongo;

@Service
public class CustomerDL implements UserDL{
	
	@Autowired
	CustomerMongo customerMongo = new CustomerMongo();

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Customer customer = customerMongo.getOneCustomer(username, password);
		if(customer != null && customer.getRole().equals("Customer")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean register(Customer customer) {
		System.out.println("111111113333");
		// TODO Auto-generated method stub
		if(customerMongo.getOneCustomer(customer.getEmail())) {
			System.out.println("111111112222");
			return false;
		}
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		customer.setShoppingCarts(list);
		customer.setRole("Customer");
		customer.setCreateTime(new Date());
		customer.setModifiedTime(customer.getCreateTime());
		customerMongo.newCustomer(customer);
		return true;
	}

}
