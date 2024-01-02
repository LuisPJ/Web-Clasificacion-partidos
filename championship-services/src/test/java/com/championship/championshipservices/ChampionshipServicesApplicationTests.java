package com.championship.championshipservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.repository.TeamRepository;
import com.championship.championshipservices.services.TeamService;

import java.util.List;
import java.util.Arrays;

@SpringBootTest
class ChampionshipServicesApplicationTests {

        @Test
        void contextLoads() {
        }

        @Mock
        private TeamRepository teamRepository;

        @InjectMocks
        private TeamService teamService;

        @Test
        void testGetTeamsSuccessful() {
                MockitoAnnotations.openMocks(this);

                Team team1 = new Team(1, "Allegoric Alaskans", 3, 2, 0, 1, 6);
                Team team2 = new Team(2, "Devastating Donkeys", 3, 2, 1, 0, 7);
                Team team3 = new Team(3, "Blithering Badgers", 3, 1, 0, 2, 3);
                Team team4 = new Team(4, "Courageous Californians", 3, 0, 1, 2, 1);
                Team team5 = new Team(5, "Adversaries of Tigers", 2, 2, 0, 0, 6);
                Team team6 = new Team(6, "Water Turtles", 1, 0, 0, 1, 0);
                Team team7 = new Team(7, "Flaying Monkeys", 1, 0, 0, 1, 0);

                // Initialize list order by 'puntos' DESC and 'nombreEquipo' ASC
                List<Team> sampleTeams = Arrays.asList(team2, team5, team1, team3, team4, team7, team6);

                when(teamRepository.findAll(Sort.by(
                                List.of(
                                                new Sort.Order(Sort.Direction.DESC, "puntos"),
                                                new Sort.Order(Sort.Direction.ASC, "nombreEquipo")))))
                                .thenReturn(sampleTeams);

                List<Team> result = teamService.getTeams();

                assertEquals(sampleTeams, result);

                verify(teamRepository, times(1)).findAll(Sort.by(
                                List.of(
                                                new Sort.Order(Sort.Direction.DESC, "puntos"),
                                                new Sort.Order(Sort.Direction.ASC, "nombreEquipo"))));

                reset(teamRepository);
        }

        @Test
        void testGetTeamsInternalError() {
                MockitoAnnotations.openMocks(this);

                when(teamRepository.findAll(Sort.by(
                                List.of(
                                                new Sort.Order(Sort.Direction.DESC, "puntos"),
                                                new Sort.Order(Sort.Direction.ASC, "nombreEquipo")))))
                                .thenThrow(new RuntimeException("Server failed"));

                assertThrows(RuntimeException.class, () -> {
                        teamService.getTeams();
                });

                verify(teamRepository).findAll(Sort.by(
                                List.of(
                                                new Sort.Order(Sort.Direction.DESC, "puntos"),
                                                new Sort.Order(Sort.Direction.ASC, "nombreEquipo"))));

                reset(teamRepository);
        }
}
