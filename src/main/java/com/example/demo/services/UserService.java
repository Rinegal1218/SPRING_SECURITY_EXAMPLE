package com.example.demo.services;

import java.util.List;

import com.example.demo.models.User;
import com.example.demo.pojos.UserPojo;

/**
 * This interface describes the UserService operations.
 * @author Rinegal1218
 */
public interface UserService {
	
	public List<User> getUsers();
	
	public User getUser(Long id);
	
	public User createUser(UserPojo user);
	
	public User updateUser(Long id, UserPojo user);
	
	public void deleteUser(Long id);

}
