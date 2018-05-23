package com.sample.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.User;
import com.sample.repository.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl extends SimpleJpaRepository<User, String> implements UserRepository {
	
	private CriteriaBuilder cb;
    private EntityManager em;

	public UserRepositoryImpl(EntityManager em) {
		super(User.class, em);
		this.em = em;
		this.cb = em.getCriteriaBuilder();
	}

	@Override
	public User getById(int id) {
        User result = null;
        try {
            result = (User) this.em.createQuery("SELECT u FROM User u WHERE id = " + id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return result;
	}

}
