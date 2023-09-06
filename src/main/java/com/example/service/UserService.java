package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.entity.UserLogin;
@Service
public interface UserService {
	public Boolean saveUser(User user);
	public User checkUser(UserLogin userLogin);
	public Boolean updatePass(UserLogin userLogin);

}
