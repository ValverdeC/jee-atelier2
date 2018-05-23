package com.sample.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.Card;
import com.sample.repository.CardRepository;

@Repository("cardRepository")
public class CardRepositoryImpl extends SimpleJpaRepository<Card, Integer> implements CardRepository {
	@SuppressWarnings("unused")
	private EntityManager em;
	
	public CardRepositoryImpl(EntityManager em) {
		super(Card.class, em);
		this.em = em;
	}

}
