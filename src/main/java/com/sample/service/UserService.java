package com.sample.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;
import com.sample.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	private List<User> users = new ArrayList<> (Arrays.asList(
			new User("Coco", 0),
			new User("Lolo", 1)
		));
	
	public User get(int id) {
		return this.repository.getById(id);
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
		for (int i = 0; i < this.users.size(); i++) {
		    User usr = this.users.get(i);
		    if (usr.getId() == id) {
		    	this.users.set(i, user);
		    }
		}
		return user;
	}

	public void delete(int id) {
		this.users.remove(id);
	}

}
