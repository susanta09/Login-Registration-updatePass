package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.User;
@Service
public interface UserService {
	public Boolean saveUser(User user);
	public User checkUser(User user);
	public Boolean updatePass(User user);

}
