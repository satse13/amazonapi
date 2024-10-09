package com.aletob.amazonapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aletob.amazonapi.dto.UserDTO;
import com.aletob.amazonapi.model.User;
import com.aletob.amazonapi.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO getUserById(Long id) {
		
		logger.info("Getting user by id: " + id);
		
		return userRepository.findById(id).map(user -> {
			return new UserDTO(user.getFirstName(), user.getSecondName(), user.getEmail());
		}).orElse(null);
		
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		
		logger.info("Getting user by email: " + email);
		
		return userRepository.findByEmail(email).map(user -> {
			return mapUserToUserDTO(user);
		}).orElse(null);
	}

	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		
		logger.info("Registering user: " + userDTO);
		
		userRepository.save(mapUserDTOToUser(userDTO));

		return userDTO;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		
		logger.info("Updating user: " + userDTO);
		
		return userRepository.findByEmail(userDTO.getEmail()).map(user -> {
			user.setFirstName(userDTO.getFirstName());
			user.setSecondName(userDTO.getSecondName());
			userRepository.save(user);
			return mapUserToUserDTO(user);
		}).orElse(null);

	}

	@Override
	public UserDTO deleteUser(UserDTO userDTO) {
		
		logger.info("Deleting user: " + userDTO);
		
		userRepository.findByEmail(userDTO.getEmail()).ifPresent(user -> {
			userRepository.delete(user);
		});
		
		return userDTO;
	}
	
	private UserDTO mapUserToUserDTO(User user) {
		return new UserDTO(user.getFirstName(), user.getSecondName(), user.getEmail());
	}

	private User mapUserDTOToUser(UserDTO userDTO) {
		return new User(userDTO.getFirstName(), userDTO.getSecondName(), userDTO.getEmail());
	}

	
}
