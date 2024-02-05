package com.championship.championshipservices.DTO;

import com.championship.championshipservices.model.Team;

public class GameDTO {

    private Team team1;
    private Team team2;
    private String result;

    public GameDTO() {
    }
    public GameDTO(Team team1, Team team2, String result) {
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
    }
    public Team getTeam1() {
        return team1;
    }
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
    public Team getTeam2() {
        return team2;
    }
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    
}
