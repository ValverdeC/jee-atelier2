package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.User;
import com.sample.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return this.service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="user")
	public User addUser(@RequestBody User user) {
		return this.service.add(user);
	}
	
	@RequestMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return this.service.get(id);
	}
}
