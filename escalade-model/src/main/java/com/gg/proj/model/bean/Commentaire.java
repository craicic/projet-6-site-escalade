package com.gg.proj.model.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Commentaire implements Model {

    // propriétés
    private Integer id;
    private Timestamp dateCreation;
    private String contenuTexte;
    private Integer utilisateurId;
    private Utilisateur utilisateur;

    // constructeurs
    public Commentaire() {
    }

    public Commentaire(Integer id) {
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

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getContenuTexte() {
        return contenuTexte;
    }

    public void setContenuTexte(String contenuTexte) {
        this.contenuTexte = contenuTexte;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
