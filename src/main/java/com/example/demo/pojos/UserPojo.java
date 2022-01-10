package com.example.demo.pojos;

import java.util.List;

public class UserPojo {
	
	private String username;
	private String password;
	private boolean enabled;
	private List<Long> roles;
	
	public UserPojo() {
		
	}
	
	public UserPojo(String username, String password, boolean enabled, List<Long> roles) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Long> getRoles() {
		return roles;
	}

	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}
	
	
	

}
