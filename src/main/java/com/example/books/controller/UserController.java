package com.example.books.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.model.User;
import com.example.books.service.UserService;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
	private final UserService userService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);

	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update")
	public User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	
}
