package com.olivtopa.paymybuddy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olivtopa.paymybuddy.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
	
	User findByEmail(String email);

}
