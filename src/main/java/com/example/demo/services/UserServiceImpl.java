package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.User;
import com.example.demo.pojos.UserPojo;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;

/**
 * This class implements UserService and UserDetailsService interfaces.
 * @author Rinegal1218
 *
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	//Dependency injection for UserRepository.
	@Autowired
	private UserRepository userRepository;
	
	//Dependency injection for RoleRepository.
	@Autowired
	private RoleRepository roleRepository;
	
	//Dependency injection for BCryptPasswordEncoder.
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * This method load an user to generate JWT.
	 * @param username for login.
	 * @return UserDetails object.
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	/**
	 * This method lists all users in database.
	 * @return List<User> object.
	 */
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	/**
	 * This method lists an user by id.
	 * @param Long user id.
	 * @return User object.
	 */
	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	/**
	 * This method creates an user in database.
	 * @param UserPojo object.
	 * @return User object that was created.
	 */
	@Override
	public User createUser(UserPojo user) {
		
		User userToCreate = new User();
		userToCreate.setUsername(user.getUsername());
		//We need to encrypt the password of the new user.
		userToCreate.setPassword(passwordEncoder.encode(user.getPassword()));
		userToCreate.setEnabled(user.isEnabled());
		userToCreate.setRoles(roleRepository.findAllById(user.getRoles()));
		return userRepository.save(userToCreate);
	}

	/**
	 * This method updates an user data.
	 * @param Long user id.
	 * @param UserPojo object.
	 * @return User object that was updated.
	 */
	@Override
	public User updateUser(Long id, UserPojo user) {
		User userToModify = userRepository.findById(id).get();
		userToModify.setUsername(user.getUsername());
		//We need to encrypt the new password of user.
		userToModify.setPassword(passwordEncoder.encode(user.getPassword()));
		userToModify.setEnabled(user.isEnabled());
		userToModify.setRoles(roleRepository.findAllById(user.getRoles()));
		return userRepository.save(userToModify);
	}

	/**
	 * This method deletes an user by id.
	 * @param Long user id.
	 */
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
