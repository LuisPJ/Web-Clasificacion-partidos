package com.championship.championshipservices.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.repository.TeamRepository;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    @Test
    void testGetTeams() {
        Team team1 = new Team(1, "Allegoric Alaskans", 3, 2, 0, 1, 6);
        Team team2 = new Team(2, "Devastating Donkeys", 3, 2, 1, 0, 7);
        Team team3 = new Team(3, "Blithering Badgers", 3, 1, 0, 2, 3);
        Team team4 = new Team(4, "Courageous Californians", 3, 0, 1, 2, 1);
        Team team5 = new Team(5, "Adversaries of Tigers", 2, 2, 0, 0, 6);
        Team team6 = new Team(6, "Water Turtles", 1, 0, 0, 1, 0);
        Team team7 = new Team(7, "Flaying Monkeys", 1, 0, 0, 1, 0);
        
        List<Team> sampleTeams = Arrays.asList(team2, team5, team1, team3, team4, team7, team6);

        when(teamRepository.findAll(Sort.by(
            List.of(
                    new Sort.Order(Sort.Direction.DESC, "puntos"),
                    new Sort.Order(Sort.Direction.ASC, "nombreEquipo")
            )
        ))).thenReturn(sampleTeams);

        List<Team> result = teamService.getTeams();

        assertEquals(sampleTeams, result);
    }
    
}
