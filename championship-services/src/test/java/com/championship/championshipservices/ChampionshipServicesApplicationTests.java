package com.championship.championshipservices;

import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.repository.LoginRepository;
import com.championship.championshipservices.services.LoginServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ChampionshipServicesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private LoginRepository loginRepository;

	@InjectMocks
	private LoginServices loginServices;

	@Test
	void testLoginUserSucessfull(){
		MockitoAnnotations.openMocks(this);

		Administrator admin = new Administrator();
		admin.setEmail("admin@example.com");
		admin.setPassword("password");

		when(loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword())).thenReturn(Optional.of(admin));

		ResponseEntity<String> response = loginServices.loginUser(admin);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Login exitoso", response.getBody());

		verify(loginRepository, times(1)).findByEmailAndPassword(admin.getEmail(), admin.getPassword());
	}


	@Test
	void testLoginUserNotFound(){
		MockitoAnnotations.openMocks(this);

		Administrator admin = new Administrator();
		admin.setEmail("admin@example.com");
		admin.setPassword("password");

		when(loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword())).thenReturn(Optional.empty());

		ResponseEntity<String> response = loginServices.loginUser(admin);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("El administrador no esta registrado en la base de datos", response.getBody());

		verify(loginRepository, times(1)).findByEmailAndPassword(admin.getEmail(), admin.getPassword());
	}

	@Test
	void testLoginUserInternalError(){
		MockitoAnnotations.openMocks(this);

		Administrator admin = new Administrator();
		admin.setEmail("admin@example.com");
		admin.setPassword("password");

		when(loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword())).thenThrow(new RuntimeException("Simulated error"));

		ResponseEntity<String> response = loginServices.loginUser(admin);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals("Error de servidor", response.getBody());

		verify(loginRepository, times(1)).findByEmailAndPassword(admin.getEmail(), admin.getPassword());
	}
}
