package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

/**
 * This interface is used to inherit JpaRepository methods to UserRepository.
 * @author Rinegal1218
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//This method is used for UserDetailsService, to load an user.
	public User findByUsername(String username);

}
