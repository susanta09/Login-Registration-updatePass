package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;
import com.example.exception.DataAlreadyExitException;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserEmailAndUserPassword(String userEmail,String UserPassword);
	User findByUserEmail(String userEmail);
}
