package com.user.auth.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.auth.service.model.User;
import com.user.auth.service.service.UserService;

@RequestMapping("/user-services")
public class UserController {
	@Autowired
	private UserService userService;

	// POST API to create a user and their session
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user) {
		// Create user in the users table along with session data in the user_sessions
		// table
		User savedUser = userService.createUser(user);

		return ResponseEntity.ok("User created successfully with ID: " + savedUser.getId());
	}
	
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        // Call the service to get all users
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}
