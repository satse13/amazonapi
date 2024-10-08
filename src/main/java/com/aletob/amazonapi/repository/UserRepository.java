package com.aletob.amazonapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aletob.amazonapi.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	Optional<User> findByEmail(String email);
	Optional<User> findByFirstName(String firstName);
	Optional<User> findBySecondName(String secondName);

}
