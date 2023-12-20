package com.championship.championshipservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.services.TeamService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API", description = "all the services related to the rugby championship")
@RestController
@RequestMapping("/api/v1")
public class ServiceController {

    @Autowired
    private TeamService teamService;

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
