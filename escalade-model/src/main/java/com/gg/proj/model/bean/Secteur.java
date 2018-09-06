package com.gg.proj.model.bean;

import java.awt.*;

public class Secteur implements Model {
    // propriétés
    private Integer id;
    private String nom;
    private String Description;
    private Point coordonneesGPS;

    // constructeurs
    public Secteur(){}

    public Secteur(Integer id) {
        this.id = id;
    }

    // setters & getters
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Point getCoordonneesGPS() {
        return coordonneesGPS;
    }

    public void setCoordonneesGPS(Point coordonneesGPS) {
        this.coordonneesGPS = coordonneesGPS;
    }
}
