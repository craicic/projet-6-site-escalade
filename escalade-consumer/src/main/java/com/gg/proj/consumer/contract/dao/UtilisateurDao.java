package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Utilisateur;

public interface UtilisateurDao extends CrudDao<Utilisateur> {

    public Utilisateur get(String identifiant);

    public String getHash(String identifiant);
}
