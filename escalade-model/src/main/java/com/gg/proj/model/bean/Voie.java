package com.gg.proj.model.bean;

public class Voie implements Model {

    // propriétés
    private Integer id;
    private String nom;
    private String description;
    private Integer nombreDePoints;
    private Integer nombreDeLongueurs;
    private String cotation;
    private String hauteur;
    private Integer secteurId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNombreDePoints() {
        return nombreDePoints;
    }

    public void setNombreDePoints(Integer nombreDePoints) {
        this.nombreDePoints = nombreDePoints;
    }

    public Integer getNombreDeLongueurs() {
        return nombreDeLongueurs;
    }

    public void setNombreDeLongueurs(Integer nombreDeLongueurs) {
        this.nombreDeLongueurs = nombreDeLongueurs;
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

    public Integer getSecteurId() {
        return secteurId;
    }

    public void setSecteurId(Integer secteurId) {
        this.secteurId = secteurId;
    }
}
