package com.gg.proj.model.bean;

import java.util.Date;

public class Empreint implements Model{
    // propriétés
    private Integer id;
    private Date dateEmpreint;
    private Date dateRetour;

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
}
