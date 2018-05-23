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
	
	/**
	 * Récupération de tous les utilisateurs
	 * 
	 * @return List<User>
	 */
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return this.service.getAll();
	}
	
	/**
	 * Ajout d'un utilisateur
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="user")
	public User addUser(@RequestBody User user) {
		return this.service.add(user);
	}
	
	/**
	 * Modification d'un utilisateur par son id
	 * 
	 * @param user
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, value="user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {
		return this.service.update(user, id);
	}
	
	/**
	 * Suppression d'un utilisateur
	 * 
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="user/{id}")
	public void deleteUser(@PathVariable int id) {
		this.service.delete(id);
	}
	
	/**
	 * Récupération d'un utilisateur par son id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("user/{id}")
	public User getUserById(@PathVariable int id) {
		return this.service.getById(id);
	}
}
