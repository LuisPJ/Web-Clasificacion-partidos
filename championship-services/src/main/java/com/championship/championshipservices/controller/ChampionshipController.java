package com.championship.championshipservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.service.TeamService;

@RestController
@RequestMapping("/championship/v1")
public class ChampionshipController {

    private TeamService teamService;

    public ChampionshipController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams(){
        return new ResponseEntity<List<Team>>(teamService.getTeams(), HttpStatus.OK); 
    }
}
