package com.gg.proj.model.bean;

public class Voie implements Model {

    // propriétés
    private Integer id;
    private String nom;
    private Integer nombreDePoints;
    private String cotation;
    // todo passer hauteur en integer ici et dans la bd
    private String hauteur;

    // constructeurs
    public Voie(){    }

    public Voie(Integer id) {
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

    public Integer getNombreDePoints() {
        return nombreDePoints;
    }

    public void setNombreDePoints(Integer nombreDePoints) {
        this.nombreDePoints = nombreDePoints;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }
}
