package com.gg.proj.model.bean;

import org.postgresql.geometric.PGpoint;

public class Secteur implements Model {
    // propriétés
    private Integer id;
    private String nom;
    private String description;
    private double coordonneeX;
    private double coordonneeY;
    private Integer siteId;


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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCoordonneeX() {
        return coordonneeX;
    }

    public void setCoordonneeX(double coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    public double getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(double coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
