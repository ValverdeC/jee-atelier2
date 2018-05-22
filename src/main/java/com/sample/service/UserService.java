package com.sample.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.model.User;

@Service
public class UserService {
	
	private List<User> users = new ArrayList<> (Arrays.asList(
			new User("Coco", 0),
			new User("Lolo", 1)
		));
	
	public User get(int id) {
		return users.get(id);
	}
	
	public List<User> getAll() {
		return users;
	}
	
	public User add(User user) {
		this.users.add(user);
		return user;
	}


}
