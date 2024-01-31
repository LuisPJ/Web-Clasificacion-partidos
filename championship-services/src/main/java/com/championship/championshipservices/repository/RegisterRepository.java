package com.championship.championshipservices.repository;

import com.championship.championshipservices.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Teams, Long> {

}
