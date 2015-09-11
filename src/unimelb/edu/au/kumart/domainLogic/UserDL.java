package unimelb.edu.au.kumart.domainLogic;

import org.springframework.stereotype.Service;

import unimelb.edu.au.kumart.entity.User;

@Service
public interface UserDL {
	
    /**
     * user login with username and password pair
     * @param username
     * @param password
     * @return if success, return true; otherwise, return false.
     */
	public abstract boolean login(String username, String password);
	
	/**
	 * user log out
	 * @return if success, return true; otherwise, return false.
	 */
	public abstract boolean logout();
	
	/**
	 * user register with provided information
	 * @param user
	 * @return if success, return true; otherwise, return false.
	 */
	public abstract boolean register(User user);
}
