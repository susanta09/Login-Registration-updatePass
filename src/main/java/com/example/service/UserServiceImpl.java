package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
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
	public User checkUser(User user)
	{
		System.out.println("check "+user);
		User u = userRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		System.out.println(u);
		return u;
	}
	@Override
	public Boolean updatePass(User user) {
		User u=userRepository.findByUserEmail(user.getUserEmail());
		if(u!=null)
		{
			u.setUserPassword(user.getUserPassword());
			userRepository.save(u);
			return true;
		}else {
			return false;
		}
		
	}
	

}
