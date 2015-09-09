package unimelb.edu.au.kumart.domainLogic;

import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.User;

@Service
public interface UserDL {
	
	public abstract boolean login(String username, String password);
	
	public abstract boolean logout();
	
	public abstract boolean register(User user);
}
