package com.gg.proj.model.bean;

import org.postgresql.geometric.PGpoint;

public class Site implements Model {

    // propriétés
    private Integer id;
    private String nom;
    private String description;
    private String profil;
    private String roche;
    private String type;
    private PGpoint coordonneesGPS;

    // constructeurs
    public Site(){}

    public Site(Integer id) {
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

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getRoche() {
        return roche;
    }

    public void setRoche(String roche) {
        this.roche = roche;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PGpoint getCoordonneesGPS() {
        return coordonneesGPS;
    }

    public void setCoordonneesGPS(PGpoint coordonneesGPS) {
        this.coordonneesGPS = coordonneesGPS;
    }
}
