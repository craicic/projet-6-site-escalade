package com.gg.proj.consumer.contract.dao;

import com.gg.proj.consumer.contract.CrudDao;
import com.gg.proj.model.bean.Utilisateur;

public interface UtilisateurDao extends CrudDao<Utilisateur> {

    public Utilisateur getByUserPseudo(String identifiant);

    public String getHash(String identifiant);

    public void updatePassword(String identifiant, String motDePasse);

    public Utilisateur getByUserMailAdress(String adresseEmail);
}
