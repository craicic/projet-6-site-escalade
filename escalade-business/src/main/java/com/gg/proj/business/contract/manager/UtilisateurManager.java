package com.gg.proj.business.contract.manager;

import com.gg.proj.business.contract.CrudManager;
import com.gg.proj.model.bean.Utilisateur;

public interface UtilisateurManager extends CrudManager<Utilisateur> {

    public Utilisateur get(String identifiant, String motDePasse);
}
