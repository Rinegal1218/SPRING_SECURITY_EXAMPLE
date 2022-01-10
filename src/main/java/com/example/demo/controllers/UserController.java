package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.UserPojo;
import com.example.demo.services.UserService;

/**
 * This class handles petitions for this example.
 * @author Rinegal1218
 */
@RestController
@RequestMapping("/api-security")
public class UserController {

	//Dependency injection of UserService.
	@Autowired
	private UserService userService;
	
	/**
	 * This method handles petitions to see all users.
	 * Everyone can access this method.
	 * @return ResponseEntity object
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		Map<String, Object> response = new HashMap<>();
		response.put("users", userService.getUsers());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * This method handles petitions to see an user by id.
	 * Everyone can access this method.
	 * @param Long user id.
	 * @return ResponseEntity object
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		
		System.out.println(id);
		Map<String, Object> response = new HashMap<>();
		response.put("user", userService.getUser(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * This method handles petitions to create a new user in database.
	 * Only ROLE_ADMIN can access this method.
	 * @param User object.
	 * @return ResponseEntity object.
	 */
	//For @Secured annotation, is necessary add ROLE_ prefix.
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody UserPojo user) {
		Map<String, Object> response = new HashMap<>();
		response.put("userCreated", userService.createUser(user));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * This method handles petitions to update an user data.
	 * Only ROLE_ADMIN can access this method.
	 * @param Long user id.
	 * @param User object.
	 * @return ResponseEntity object
	 */
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> modifyUser(@PathVariable Long id, @RequestBody UserPojo user) {
		Map<String, Object> response = new HashMap<>();
		response.put("userUpdated", userService.updateUser(id, user));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * This method handles petitions to delete an user by id.
	 * Only ROLE_ADMIN can access this method.
	 * @param Long user id.
	 * @return ResponseEntity object.
	 */
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		userService.deleteUser(id);
		response.put("message", "User with id: " + id + " was deleted successfully");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
