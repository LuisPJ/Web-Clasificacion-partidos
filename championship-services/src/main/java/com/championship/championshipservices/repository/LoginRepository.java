package com.championship.championshipservices.repository;

import com.championship.championshipservices.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByEmailAndPassword(String email, String password);
}
