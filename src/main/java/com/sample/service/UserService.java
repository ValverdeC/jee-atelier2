package com.sample.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;
import com.sample.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CardService cardService;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(String id) {
		return userRepository.findOne(Integer.valueOf(id));
	}

	public String addUser(User user) {
		user.setCards(cardService.getRandomCards(5));
		SecureRandom random = new SecureRandom();
		String key = getSaltString();
		user.setToken(key);
		userRepository.save(user);
		return user.getToken();
	}

	public void updateUser(User poney) {
		userRepository.save(poney);
	}

	public void deleteUser(String id) {
		userRepository.delete(Integer.valueOf(id));
	}

	public User getUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User getUserByToken(String token) {
		return userRepository.findByToken(token);
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		SecureRandom rnd = new SecureRandom();
		while (salt.length() < 32) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

}