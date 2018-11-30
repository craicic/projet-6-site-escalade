package com.gg.proj.business.contract.manager;

import com.gg.proj.business.contract.CrudManager;
import com.gg.proj.model.bean.Utilisateur;

public interface UtilisateurManager extends CrudManager<Utilisateur> {

    public Utilisateur get(String identifiant, String motDePasse) throws Exception;

    public boolean isCorrectPassword(String identifiant, String motDePasse);

    public void updatePassword(String identifiant, String motDePasse);

    Utilisateur getById(Integer id);
}
