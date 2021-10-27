package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User>getUsers(){
		return userRepository.findAll();
		
	}
}
