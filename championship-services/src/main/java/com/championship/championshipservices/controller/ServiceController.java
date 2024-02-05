package com.championship.championshipservices.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.services.TeamService;
import com.championship.championshipservices.DTO.GameDTO;
import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.services.LoginServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Championship Services", description = "Services in app")
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000/")
public class ServiceController {

    @Autowired
    private LoginServices championService;
  
    @Autowired
    private TeamService teamService;


    @Operation(
            summary = "Login for the admin",
            description = "Allows the system administrator to log in")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @GetMapping("/login")
    public ResponseEntity<String> loginUser(
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password
    ) {
        Administrator admin = new Administrator();
        admin.setEmail(email);
        admin.setPassword(password);
        return championService.loginUser(admin);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Team teams) {
        return championService.registerTeam(teams);
    }

    @PostMapping("/register-game")
    public ResponseEntity<String> registerGame(@RequestBody GameDTO gameDto) {
        return championService.registerGame(gameDto.getTeam1(), gameDto.getTeam2(), gameDto.getResult());
    }
  
  @Operation(
        summary = "Fetch all teams", 
        description = "Fetches all the teams and their information from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @GetMapping(value = "/teams", produces = "application/json")
    public ResponseEntity<List<Team>> getAllTeams(){
        try{
            List<Team> teams = teamService.getTeams();
            return new ResponseEntity<List<Team>>(teams,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    } 
}
