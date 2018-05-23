package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Card;
import com.sample.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;
	
	public Card getById(int id) {
		return this.repository.findOne(id);
	}
	
	public List<Card> getAll() {
		List<Card> cards = new ArrayList<>();
		this.repository.findAll()
			.forEach(cards::add);
		return cards;
	}
	
	public Card add(Card card) {
		return this.repository.save(card);
	}
	
	public Card update(Card card, int id) {
		return this.repository.save(card);
	}

	public void delete(int id) {
		this.repository.delete(id);
	}

    public Card getByName(String name) {
		return this.repository.findByName(name);
    }
}
