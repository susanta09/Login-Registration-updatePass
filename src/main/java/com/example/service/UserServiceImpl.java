package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.entity.UserLogin;
import com.example.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Boolean saveUser(User user) {
		User u=userRepository.save(user);
		if(u!=null)
		{
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public User checkUser(UserLogin userLogin)
	{
		System.out.println("check "+userLogin);
		User u = userRepository.findByUserEmailAndUserPassword(userLogin.getUserEmail(), userLogin.getUserPassword());
		System.out.println(u);
		return u;
	}
	@Override
	public Boolean updatePass(UserLogin userLogin) {
		User u=userRepository.findByUserEmail(userLogin.getUserEmail());
		if(u!=null)
		{
			u.setUserPassword(userLogin.getUserPassword());
			userRepository.save(u);
			return true;
		}else {
			return false;
		}
		
	}
	

}
