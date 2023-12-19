package com.championship.championshipservices.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    private Team team;

    private int idTeam = 1;
    private String nombreEquipo = "TeamA";
    private int partidosJugados = 2;
    private int victorias = 0;
    private int derrotas = 1;
    private int empates = 1;
    private int puntos = 1;

    @BeforeEach
    public void setUpTeam(){
        team = new Team(idTeam, nombreEquipo, partidosJugados, victorias, derrotas, empates, puntos);
    }

    @AfterEach
    public void tearDown(){
        team = null;
    }

    @Test
    void testGetIdTeam() {
        assertEquals(idTeam, team.getIdTeam());
    }

    @Test
    void testGetNombreEquipo() {
        assertEquals(nombreEquipo, team.getNombreEquipo());
    }

    @Test
    void testGetNumeroDePartidosJugados() {
        assertEquals(partidosJugados, team.getNumeroDePartidosJugados());
    }

    @Test
    void testGetNumeroDerrotas() {
        assertEquals(derrotas, team.getNumeroDerrotas());
    }

    @Test
    void testGetNumeroEmpates() {
        assertEquals(empates, team.getNumeroEmpates());
    }

    @Test
    void testGetNumeroVictorias() {
        assertEquals(victorias, team.getNumeroVictorias());
    }

    @Test
    void testGetPuntos() {
        assertEquals(puntos, team.getPuntos());
    }

    @Test
    void testSetIdTeam() {
        int id = 2;
        team.setIdTeam(id);
        assertEquals(id, team.getIdTeam());
    }

    @Test
    void testSetNombreEquipo() {
        String nombre = "TeamB";
        team.setNombreEquipo(nombre);
        assertEquals(nombre, team.getNombreEquipo());
    }

    @Test
    void testSetNumeroDePartidosJugados() {
        int partidos = 9;
        team.setNumeroDePartidosJugados(partidos);
        assertEquals(partidos, team.getNumeroDePartidosJugados());
    }

    @Test
    void testSetNumeroDerrotas() {
        int derrotas = 4;
        team.setNumeroDerrotas(derrotas);
        assertEquals(derrotas, team.getNumeroDerrotas());
    }

    @Test
    void testSetNumeroEmpates() {
        int empates = 3;
        team.setNumeroEmpates(empates);
        assertEquals(empates, team.getNumeroEmpates());
    }

    @Test
    void testSetNumeroVictorias() {
        int victorias = 2;
        team.setNumeroVictorias(victorias);
        assertEquals(victorias, team.getNumeroVictorias());
    }

    @Test
    void testSetPuntos() {
        int puntos = 5;
        team.setPuntos(puntos);
        assertEquals(puntos, team.getPuntos());
    }

    @Test
    void testToString() {
        String expectedToString = "Team [idTeam="+idTeam+", nombreEquipo="+nombreEquipo+", numeroDePartidosJugados="+partidosJugados+", "
                + "numeroVictorias="+victorias+", numeroDerrotas="+derrotas+", numeroEmpates="+empates+", puntos="+puntos+"]";
        assertEquals(expectedToString, team.toString());
    }

    @Test
    public void testDefaultConstructor() {
        Team defaultTeam = new Team();
        assertNotNull(defaultTeam);
    }

}
