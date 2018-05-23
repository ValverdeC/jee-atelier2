package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.jpa.exception.ResourceNotFoundException;
import com.sample.model.Card;
import com.sample.model.User;
import com.sample.repository.CardRepository;
import com.sample.repository.UserRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	public Card getById(int id) {
		return this.repository.findOne(id);
	}
	
	public List<Card> getAll() {
		List<Card> cards = new ArrayList<>();
		this.repository.findAll()
			.forEach(cards::add);
		return cards;
	}
	
	public Card add(Card card, int id) {
		 User user = this.userRepository.findOne(id);
		 if (user != null) {
			 card.setUser(user);
			 return this.repository.save(card);
		 } else {
			 throw new ResourceNotFoundException("UserId " + id + " not found");
		 }
	}
	
	public Card update(Card card, int id) {
		return this.repository.save(card);
	}

	public void delete(int id) {
		this.repository.delete(id);
	}

    public Card getByName(String name) {

		return null;//this.repository.findByName(name);
    }
}
