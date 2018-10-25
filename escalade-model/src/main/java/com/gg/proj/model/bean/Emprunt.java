package com.gg.proj.model.bean;

import java.util.Date;

public class Emprunt implements Model{
    // propriétés
    private Integer id;
    private Date dateEmprunt;
    private Date dateRetour;
    private Integer utilisateurId;
    private Integer topoId;

    // constructeurs
    public Emprunt(){}

    public Emprunt(Integer id) {
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

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
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

    public Integer getTopoId() {
        return topoId;
    }

    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }
}
