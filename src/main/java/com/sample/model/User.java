package com.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	//Id auto-généré
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String name;

	/************************/
	/*** Getter & Setters ***/
	/************************/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
