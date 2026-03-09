package com.user.auth.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.auth.service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
