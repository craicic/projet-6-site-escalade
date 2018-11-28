package com.gg.proj.model.bean;

import java.time.LocalDate;

public class Emprunt implements Model{
    // propriétés
    private Integer id;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
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

    public Emprunt(LocalDate dateEmprunt, LocalDate dateRetour){
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    // setters & getters
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
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
