package unimelb.edu.au.kumart.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	private String email;
	private String password;
	private String role;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	

}
