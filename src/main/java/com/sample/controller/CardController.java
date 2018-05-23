package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Card;
import com.sample.service.CardService;

@RestController
public class CardController {
	
	@Autowired
	private CardService service;
	
	@RequestMapping("/cards")
	public List<Card> getAllCards() {
		return this.service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="card")
	public Card addCard(@RequestBody Card card) {
		return this.service.add(card);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="card/{id}")
	public Card updateCard(@RequestBody Card card, @PathVariable int id) {
		return this.service.update(card, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="card/{id}")
	public void deleteCard(@PathVariable int id) {
		this.service.delete(id);
	}
	
	@RequestMapping("card/{id}")
	public Card getCardById(@PathVariable int id) {
		return this.service.getById(id);
	}

}
