package com.dxc.scb.Controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.scb.Repository.AddressRepository;
import com.dxc.scb.Repository.UserRepository;
import com.dxc.scb.model.Address;
import com.dxc.scb.model.User;

@RestController
public class UserController {
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public AddressRepository addressRepository;

	@PostMapping("/user-registration")
	public ResponseEntity<String> registerUser(@RequestBody User request) {

		User user = new User();
		user.setRole(request.getRole());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setUsername(request.getUsername());

		Address address = new Address();
		address.setStreet(request.getAddress().getStreet());
		address.setCity(request.getAddress().getCity());
		address.setZipCode(request.getAddress().getZipCode());

		addressRepository.save(address);

		user.setAddress(address);

		userRepository.save(user);

		return ResponseEntity.ok("User registered successfully");
	}

}
