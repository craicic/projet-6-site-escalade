package com.gg.proj.business.contract;

import com.gg.proj.business.contract.manager.*;
import com.gg.proj.model.bean.Secteur;

public interface ManagerFactory {

    CommentaireManager getCommentaireManager();

    EmpreintManager getEmpreintManager();

    SecteurManager getSecteurManager();

    SiteManager getSiteManager();

    TopoManager getTopoManager();

    UtilisateurManager getUtilisateurManager();

    VoieManager getVoieManager();
}
