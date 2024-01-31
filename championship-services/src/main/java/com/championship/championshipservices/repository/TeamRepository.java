package com.championship.championshipservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.championship.championshipservices.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
    
}
