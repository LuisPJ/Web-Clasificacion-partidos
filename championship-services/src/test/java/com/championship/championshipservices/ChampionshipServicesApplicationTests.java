package com.championship.championshipservices;

import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.model.Teams;
import com.championship.championshipservices.repository.LoginRepository;
import com.championship.championshipservices.repository.RegisterRepository;
import com.championship.championshipservices.repository.TeamRepository;
import com.championship.championshipservices.services.LoginServices;
import com.championship.championshipservices.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ChampionshipServicesApplicationTests{

        }

	@Mock
	private LoginRepository loginRepository;

	@Mock
	private RegisterRepository registerRepository;

	@InjectMocks
	private LoginServices loginServices;

	@Mock
	private TeamRepository teamRepository;

	@InjectMocks
	private TeamService teamService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // Inicializar las anotaciones de Mockito
	}

	@Test
	void loginSuccess() {
		Administrator admin = new Administrator("test@example.com", "password");
		when(loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword()))
				.thenReturn(Optional.of(admin));

		ResponseEntity<String> response = loginServices.loginUser(admin);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Login exitoso", response.getBody());
	}

	@Test
	void loginNotFound() {
		Administrator admin = new Administrator("test@example.com", "password");
		when(loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword()))
				.thenReturn(Optional.empty());
		ResponseEntity<String> response = loginServices.loginUser(admin);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("El administrador no esta registrado en la base de datos", response.getBody());
	}

	@Test
	void loginInternalServerError() {
		Administrator admin = new Administrator("test@example.com", "password");
		when(loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword()))
				.thenThrow(new RuntimeException("Simulated internal server error"));
		ResponseEntity<String> response = loginServices.loginUser(admin);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals("Error de servidor", response.getBody());
	}

	@Test
	void registerTeamSuccess() {
		Teams teams = new Teams();
		Mockito.doReturn(null).when(registerRepository).save(teams);

		ResponseEntity<String> response = loginServices.registerTeam(teams);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Registro exitoso", response.getBody());
	}

	@Test
	void registerTeamInternalServerError() {
		Teams teams = new Teams();
		Mockito.doThrow(new RuntimeException("Simulated internal server error")).when(registerRepository).save(teams);

		ResponseEntity<String> response = loginServices.registerTeam(teams);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals("Error de servidor", response.getBody());
	}

	@Test
	void registerGameVictory() {
		Teams team1 = new Teams();
		Teams team2 = new Teams();
		String result = "VICTORIA";

		ResponseEntity<String> response = loginServices.registerGame(team1, team2, result);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Registro exitoso", response.getBody());
	}

	@Test
	void registerGameDefeated() {
		Teams team1 = new Teams();
		Teams team2 = new Teams();
		String result = "DERROTA";

		ResponseEntity<String> response = loginServices.registerGame(team1, team2, result);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Registro exitoso", response.getBody());
	}

	@Test
	void registerGameDraw() {
		Teams team1 = new Teams();
		Teams team2 = new Teams();
		String result = "EMPATE";

		ResponseEntity<String> response = loginServices.registerGame(team1, team2, result);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Registro exitoso", response.getBody());
	}

	@Test
	void registerGameInternalServerError() {
		Teams team1 = new Teams();
		Teams team2 = new Teams();
		String result = "VICTORIA";
		Mockito.doThrow(new RuntimeException("Simulated internal server error")).when(registerRepository).save(any());

		ResponseEntity<String> response = loginServices.registerGame(team1, team2, result);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals("Error de servidor", response.getBody());
	}

	@Test
	void getTeams() {
		List<Team> mockTeams = new ArrayList<>();
		mockTeams.add(new Team("Equipo1", 10));
		mockTeams.add(new Team("Equipo2", 5));

		when(teamRepository.findAll(Sort.by(
				Sort.Order.desc("puntos"),
				Sort.Order.asc("nombreEquipo")
		))).thenReturn(mockTeams);


		List<Team> result = teamService.getTeams();
		assertNotNull(result, "La lista de equipos no debería ser nula");
		assertEquals(2, result.size(), "El tamaño de la lista de equipos no es el esperado");

		System.out.println("Equipos obtenidos:");
		result.forEach(team -> System.out.println("Nombre: " + team.getNombreEquipo() + ", Puntos: " + team.getPuntos()));

		System.out.println("Equipos configurados en el mock:");
		mockTeams.forEach(team -> System.out.println("Nombre: " + team.getNombreEquipo() + ", Puntos: " + team.getPuntos()));
	}

}
