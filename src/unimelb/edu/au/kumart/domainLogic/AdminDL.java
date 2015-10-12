package unimelb.edu.au.kumart.domainLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.Admin;
import unimelb.edu.au.kumart.entity.Customer;
import unimelb.edu.au.kumart.entity.User;
import unimelb.edu.au.kumart.mongodb.AdminMongo;

@Service
public class AdminDL implements UserDL{
	
	@Autowired
	private AdminMongo adminMongo;

	/**
	 * check if the username and password pair is exist and then check if the role of the user is Admin.
	 * @param username
	 * @param password
	 * @return if the role is admin, return true. otherwise, return false.
	 */
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = adminMongo.login(username, password);
		if(admin != null && admin.getRole().equals("Admin")) return true;
		return false;
	}

	@Override
	public boolean register(Customer user) {
		// TODO Auto-generated method stub
		return false;
	}

}
