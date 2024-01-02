package com.championship.championshipservices.controller;

import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.model.Teams;
import com.championship.championshipservices.services.LoginServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Championship Services", description = "Services in app")
@RestController
@RequestMapping("/api/v1")
public class ServiceController {

    @Autowired
    private LoginServices championService;


    @Operation(
            summary = "Login for the admin",
            description = "Allows the system administrator to log in")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Administrator admin) {
        return championService.loginUser(admin);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Teams teams) {
        return championService.registerTeam(teams);
    }

    @PostMapping("/register-game")
    public ResponseEntity<String> registerGame(@RequestBody Teams team1, Teams team2, String result) {
        return championService.registerGame(team1, team2, result);
    }
}
