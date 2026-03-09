package com.user.auth.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.auth.service.model.User;
import com.user.auth.service.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		// Save user to the `users` table
		return userRepository.save(user);
	}
	
    public List<User> getAllUsers() {
        // This fetches all users and their associated session data
        return userRepository.findAll();
    }
}
