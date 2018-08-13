package com.gg.proj.model.bean;

import com.gg.proj.model.bean.Model;

public class Topo implements Model {

    private Integer id;
    private String auteur;
    private String nom;
    private String description;
    //TODO Sites[] et Commentaires[]

    public Topo(){}

    public Topo(Integer pId){id = pId;}

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

}
