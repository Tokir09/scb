package com.dxc.scb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.dxc.scb.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	// public ResponseEntity<String> registerUser(@RequestBody User user);

}
