package com.gg.proj.model.bean;

public class Topo implements Model {

    // propriétés
    private Integer id;
    private String auteur;
    private String titre;
    private String description;
    private boolean empreintable;

    // constructeurs
    public Topo() {
    }

    public Topo(Integer id) {
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

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEmpreintable() {
        return empreintable;
    }

    public void setEmpreintable(boolean empreintable) {
        this.empreintable = empreintable;
    }
}
