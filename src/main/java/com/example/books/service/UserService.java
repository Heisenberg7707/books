package com.example.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.books.exception.ResourceNotFoundException;
import com.example.books.model.User;
import com.example.books.repo.UserRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@AllArgsConstructor
public class UserService {
	private final UserRepo userRepo ;
	
	
	public List<User> getAllUsers(){
		List<User> users = userRepo.findAll();
		log.info("Getting {} users", users.size());
		return users;

	}
	
	public User saveUser(User user) {
		log.info("Saving user: {}", user);
		return userRepo.save(user);
	}
	
	
	public void deleteUserById(Long id) {
		log.info("Deleting user by id {}", id);
		userRepo.deleteById(id);
	}
	
	public Optional<User> findById(Long id){
		return userRepo.findById(id);
	}
	
	public User updateUser(User user) {
		userRepo.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + user.getId()));
		return userRepo.save(user);
	}
	
}
