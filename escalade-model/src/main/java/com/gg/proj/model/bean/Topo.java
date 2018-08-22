package com.gg.proj.model.bean;

public class Topo implements Model {

    private Integer id;
    private String auteur;
    private String titre;
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

    @Override
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
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) { this.titre = titre; }

}
