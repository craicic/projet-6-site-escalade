package com.gg.proj.model.bean;

import org.postgresql.geometric.PGpoint;

public class Secteur implements Model {
    // propriétés
    private Integer id;
    private String nom;
    private String description;
    private PGpoint coordonneesGPS;
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

    public PGpoint getCoordonneesGPS() {
        return coordonneesGPS;
    }

    public void setCoordonneesGPS(PGpoint coordonneesGPS) {
        this.coordonneesGPS = coordonneesGPS;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
