package com.championship.championshipservices.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
public class Team implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int idTeam;

    @Column(name = "nombreDeEquipo", unique = true, nullable = false, length = 50)
    private String nombreEquipo;

    @Column(name = "numeroDePartidosJugados", nullable = false)
    private int numeroDePartidosJugados;
    
    @Column(name = "numeroVictorias", nullable = false)
    private int numeroVictorias;

    @Column(name = "numeroDerrotas", nullable = false)
    private int numeroDerrotas;

    @Column(name = "numeroEmpates", nullable = false)
    private int numeroEmpates;

    @Column(name = "puntos", nullable = false)
    private int puntos;

    public Team() {
    }

    public Team(int idTeam, String nombreEquipo, int numeroDePartidosJugados, int numeroVictorias, int numeroDerrotas,
            int numeroEmpates, int puntos) {
        this.idTeam = idTeam;
        this.nombreEquipo = nombreEquipo;
        this.numeroDePartidosJugados = numeroDePartidosJugados;
        this.numeroVictorias = numeroVictorias;
        this.numeroDerrotas = numeroDerrotas;
        this.numeroEmpates = numeroEmpates;
        this.puntos = puntos;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getNumeroDePartidosJugados() {
        return numeroDePartidosJugados;
    }

    public void setNumeroDePartidosJugados(int numeroDePartidosJugados) {
        this.numeroDePartidosJugados = numeroDePartidosJugados;
    }

    public int getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(int numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public int getNumeroDerrotas() {
        return numeroDerrotas;
    }

    public void setNumeroDerrotas(int numeroDerrotas) {
        this.numeroDerrotas = numeroDerrotas;
    }

    public int getNumeroEmpates() {
        return numeroEmpates;
    }

    public void setNumeroEmpates(int numeroEmpates) {
        this.numeroEmpates = numeroEmpates;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Team [idTeam=" + idTeam + ", nombreEquipo=" + nombreEquipo + ", numeroDePartidosJugados="
                + numeroDePartidosJugados + ", numeroVictorias=" + numeroVictorias + ", numeroDerrotas="
                + numeroDerrotas + ", numeroEmpates=" + numeroEmpates + ", puntos=" + puntos + "]";
    }

    
}
