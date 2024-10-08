package com.aletob.amazonapi.service;

import org.springframework.stereotype.Service;

import com.aletob.amazonapi.dto.UserDTO;
@Service
public interface UserService {
	
	UserDTO getUserById(Long id);
	UserDTO getUserByEmail(String email);
	UserDTO registerUser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO);
	UserDTO deleteUser(UserDTO userDTO);

}
