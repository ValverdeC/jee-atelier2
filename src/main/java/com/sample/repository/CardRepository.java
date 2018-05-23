package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.sample.model.Card;

@NoRepositoryBean
public interface CardRepository extends JpaRepository<Card, Integer> {

}
