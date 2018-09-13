package com.gg.proj.business.contract;

import com.gg.proj.business.contract.manager.*;

public interface ManagerFactory {

    CommentaireManager getCommentaireManager();

    CommentaireSurTopoManager getCommentaireSurTopoManager();

    EmpreintManager getEmpreintManager();

    SecteurManager getSecteurManager();

    SiteManager getSiteManager();

    TopoManager getTopoManager();

    UtilisateurManager getUtilisateurManager();

    VoieManager getVoieManager();
}
