package com.gg.proj.model.bean;

import java.util.Date;

public class Commentaire implements Model {
    // propriétés
    private Integer id;
    private Date dateCreation;
    private String contenuTexte;

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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getContenuTexte() {
        return contenuTexte;
    }

    public void setContenuTexte(String contenuTexte) {
        this.contenuTexte = contenuTexte;
    }
}
