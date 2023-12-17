package com.championship.championshipservices.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.List;

import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.repository.TeamRepository;

@Service
public class TeamService {
    
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams(){
        return teamRepository.findAll(Sort.by(
            List.of(
                new Order(Sort.Direction.DESC, "puntos"),
                new Order(Sort.Direction.ASC, "nombreEquipo")
            )
        ));
    }
}
