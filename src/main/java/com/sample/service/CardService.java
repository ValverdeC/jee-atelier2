package com.sample.service;

import java.security.SecureRandom;
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
	private CardRepository cardrepository;
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Récupération d'une card par son id
	 * 
	 * @param id
	 * @return Card
	 */
	public Card getById(int id) {
		return this.cardrepository.findOne(id);
	}
	
	/**
	 * Récupération de toutes les card
	 * 
	 * @return List<Card>
	 */
	public List<Card> getAll() {
		List<Card> cards = new ArrayList<>();
		this.cardrepository.findAll()
			.forEach(cards::add);
		return cards;
	}
	
	/**
	 * Ajout d'une carte pour un utilisateur
	 * 
	 * @param card
	 * @param id
	 * @return Card
	 */
	public Card add(Card card, int id) {
		 User user = this.userRepository.findOne(id);
		 if (user != null) {
			 card.setUser(user);
			 return this.cardrepository.save(card);
		 } else {
			 throw new ResourceNotFoundException("UserId " + id + " not found");
		 }
	}
	
	/**
	 * Modification d'une card par son id
	 * 
	 * @param card
	 * @param id
	 * @return Card
	 */
	public Card update(Card card, int id) {
		return this.cardrepository.save(card);
	}

	/**
	 * Suppresion d'une carte par son id
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.cardrepository.delete(id);
	}

    public Card getByName(String name) {

		return null;//this.repository.findByName(name);
    }

	public List<Card> getRandomCards(int numberOfCards) {
		List<Card> randomCards = new ArrayList<>();
		List<Card> cards = new ArrayList<>();
		cardrepository.findAll().forEach(cards::add);

		SecureRandom rand = new SecureRandom();
		int sizeMin = Math.min(numberOfCards, cards.size());
		for (int i = 0; i < sizeMin; i++) {
			randomCards.add( cards.remove( rand.nextInt( cards.size() ) ));
		}

		return randomCards;
	}
}
