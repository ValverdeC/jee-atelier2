package com.sample.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.User;
import com.sample.repository.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl extends SimpleJpaRepository<User, Integer> implements UserRepository {
	
    @SuppressWarnings("unused")
	private EntityManager em;

	public UserRepositoryImpl(EntityManager em) {
		super(User.class, em);
		this.em = em;
	}

}
