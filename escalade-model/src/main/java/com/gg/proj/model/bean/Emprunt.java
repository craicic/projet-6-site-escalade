package com.gg.proj.model.bean;

import java.util.Date;

public class Emprunt implements Model{
    // propriétés
    private Integer id;
    private Date dateEmprunt;
    private Date dateRetour;
    private Integer utilisateurId;
    private Integer topoId;
    private Topo topo;
    private Utilisateur emprunteur;
    private Utilisateur proprietaire;

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

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Utilisateur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Utilisateur emtpruteur) {
        this.emprunteur = emtpruteur;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }
}
