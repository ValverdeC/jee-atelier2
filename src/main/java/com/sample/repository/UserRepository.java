package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.sample.model.User;

@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, String> {
	/**
     * Récupére un user à partir de son id
     *
     * @return un user ou une erreur 404 s'il n'est pas trouvé
     */
    User getById(int id);
}
