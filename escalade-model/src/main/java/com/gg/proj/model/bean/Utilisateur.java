package com.gg.proj.model.bean;

import java.util.Date;

public class Utilisateur implements Model {

    // propriétés
    private Integer id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String adresse;
    private String description;
    private String adresseMail;
    private Date dateInscription;
    private String uuid;
    private String hashMotDePasse;

    // constructeurs
    public Utilisateur(){}

    public Utilisateur(Integer id) {
        this.id = id;
    }

    public Utilisateur(String pseudo) {this.pseudo = pseudo; }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHashMotDePasse() {
        return hashMotDePasse;
    }

    public void setHashMotDePasse(String hashMotDePasse) {
        this.hashMotDePasse = hashMotDePasse;
    }
}
