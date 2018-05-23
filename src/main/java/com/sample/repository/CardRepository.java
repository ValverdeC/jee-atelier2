package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.model.Card;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Query("SELECT c FROM Card WHERE c.name = ?")
    public Card findByName(String name);
}
