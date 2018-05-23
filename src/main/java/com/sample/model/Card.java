package com.sample.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Card")
public class Card implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "imgUrl")
	private String imgUrl;

	@Column(name = "family")
	private String family;

	@Column(name = "affinity")
	private String affinity;

	@Column(name = "hp")
	private int hp;

	@Column(name = "energy")
	private int energy;

	@Column(name = "attack")
	private int attack;

	@Column(name = "defence")
	private int defence;
	
	public Card(String name, String description, String imgUrl, String family, String affinity, int hp, int energy,
			int attack, int defence) {
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
	}
	
	public Card() {
		this.name = "";
		this.description = "";
		this.imgUrl = "";
		this.family = "";
		this.affinity = "";
		this.hp = 0;
		this.energy = 0;
		this.attack = 0;
		this.defence = 0;
	}

	/************************/
	/*** Getter & Setters ***/
	/************************/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getAffinity() {
		return affinity;
	}
	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}

}
