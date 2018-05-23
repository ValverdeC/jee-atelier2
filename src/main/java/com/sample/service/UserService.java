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
	
	/**
	 * Récupération d'un user par son id
	 * 
	 * @param id
	 * @return User
	 */
	public User getById(int id) {
		return this.repository.findOne(id);
	}
	
	/**
	 * Récupération de tous les users
	 * 
	 * @return List<User>
	 */
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		this.repository.findAll()
			.forEach(users::add);
		return users;
	}
	
	/**
	 * Ajout d'un user
	 * 
	 * @param user
	 * @return User
	 */
	public User add(User user) {
		return this.repository.save(user);
	}
	
	/**
	 * Modification d'un user par son id
	 * 
	 * @param user
	 * @param id
	 * @return User
	 */
	public User update(User user, int id) {
		return this.repository.save(user);
	}

	/**
	 * Suppression d'un user par son id
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.repository.delete(id);
	}

}
