package unimelb.edu.au.kumart.domainLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.User;
import unimelb.edu.au.kumart.mongodb.AdminMongo;

@Service
public class AdminDL implements UserDL{
	
	@Autowired
	private AdminMongo adminMongo;

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if(adminMongo.login(username, password)) return true;
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
