package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Role;

/**
 * This interface is used to inherit JpaRepository methods to UserRepository.
 * @author Rinegal1218
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
