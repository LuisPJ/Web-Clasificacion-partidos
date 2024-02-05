package com.championship.championshipservices.repository;

import com.championship.championshipservices.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Administrator, Integer> {
    Optional<Administrator> findByEmailAndPassword(String email, String password);
}
