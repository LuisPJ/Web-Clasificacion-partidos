package com.championship.championshipservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.service.TeamService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Championship", description = "the Championship Api")
@RestController
@RequestMapping("/championship/v1")
public class ChampionshipController {

    private TeamService teamService;

    public ChampionshipController(TeamService teamService) {
        this.teamService = teamService;
    }

    @Operation(
        summary = "Fetch all teams", 
        description = "Fetches all the teams and their information from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @GetMapping(value = "/teams", produces = "application/json")
    public ResponseEntity<List<Team>> getAllTeams(){
        return new ResponseEntity<List<Team>>(teamService.getTeams(), HttpStatus.OK); 
    }
}
