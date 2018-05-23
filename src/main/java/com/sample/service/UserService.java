package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;
import com.sample.repository.UserRepository;

@Service
public class UserService {


	
	@Autowired
	private UserRepository repository;
	
	public User getById(int id) {
		return this.repository.findOne(id);
	}
	
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		this.repository.findAll()
			.forEach(users::add);
		return users;
	}
	
	public User add(User user) {
		return this.repository.save(user);
	}
	
	public User update(User user, int id) {
		return this.repository.save(user);
	}

	public void delete(int id) {
		this.repository.delete(id);
	}

}
