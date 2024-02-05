package com.championship.championshipservices.services;

import com.championship.championshipservices.model.Administrator;
import com.championship.championshipservices.model.Team;
import com.championship.championshipservices.repository.LoginRepository;
import com.championship.championshipservices.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServices {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private TeamRepository teamRepository;

    public ResponseEntity<String> loginUser(Administrator admin) {
        try {
            Optional<Administrator> adminLogin = loginRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
            if(adminLogin.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El administrador no esta registrado en la base de datos");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body("Login exitoso");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de servidor");
        }
    }

    public ResponseEntity<String> registerTeam(Team team) {
        try {
            teamRepository.save(team);
            return ResponseEntity.status(HttpStatus.OK).body("Registro exitoso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de servidor");
        }
    }

    public ResponseEntity<String> registerGame(Team team1, Team team2, String result) {
        try {
            team1 = teamRepository.findById(team1.getIdTeam()).get();
            team2 = teamRepository.findById(team2.getIdTeam()).get();

            if(result.equals("VICTORIA")){
                team1.setNumeroDePartidosJugados(team1.getNumeroDePartidosJugados()+1);
                team1.setNumeroVictorias(team1.getNumeroVictorias()+1);
                team1.setPuntos(team1.getPuntos()+3);
                team2.setNumeroDePartidosJugados(team2.getNumeroDePartidosJugados()+1);
                team2.setNumeroDerrotas(team2.getNumeroDerrotas()+1);
            }else if(result.equals("DERROTA")){
                team2.setNumeroDePartidosJugados(team2.getNumeroDePartidosJugados()+1);
                team2.setNumeroVictorias(team2.getNumeroVictorias()+1);
                team2.setPuntos(team2.getPuntos()+3);
                team1.setNumeroDePartidosJugados(team1.getNumeroDePartidosJugados()+1);
                team1.setNumeroDerrotas(team1.getNumeroDerrotas()+1);
            }else{
                team2.setNumeroDePartidosJugados(team2.getNumeroDePartidosJugados()+1);
                team2.setPuntos(team2.getPuntos()+1);
                team1.setNumeroDePartidosJugados(team1.getNumeroDePartidosJugados()+1);
                team1.setPuntos(team1.getPuntos()+1);
                team1.setNumeroEmpates(team1.getNumeroEmpates()+1);
                team2.setNumeroEmpates(team2.getNumeroEmpates()+1);
            }
            teamRepository.save(team1);
            teamRepository.save(team2);
            return ResponseEntity.status(HttpStatus.OK).body("Registro exitoso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de servidor");
        }
    }
}
