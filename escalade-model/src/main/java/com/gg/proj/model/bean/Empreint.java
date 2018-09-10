package com.gg.proj.model.bean;

import java.util.Date;

public class Empreint implements Model{
    // propriétés
    private Integer id;
    private Date dateEmpreint;
    private Date dateRetour;
    private Integer utilisateurId;

    // constructeurs
    public Empreint(){}

    public Empreint(Integer id) {
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

    public Date getDateEmpreint() {
        return dateEmpreint;
    }

    public void setDateEmpreint(Date dateEmpreint) {
        this.dateEmpreint = dateEmpreint;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
