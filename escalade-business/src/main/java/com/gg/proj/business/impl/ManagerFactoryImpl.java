package com.gg.proj.business.impl;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.business.contract.manager.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private CommentaireManager commentaireManager;

    @Inject
    private CommentaireSurTopoManager commentaireSurTopoManager;

    @Inject
    private EmpruntManager empruntManager;

    @Inject
    SecteurManager secteurManager;

    @Inject
    private SiteManager siteManager;

    @Inject
    private TopoManager topoManager;

    @Inject
    private UtilisateurManager utilisateurManager;

    @Inject
    private VoieManager voieManager;

    @Inject
    private RechercheManager rechercheManager;

    @Override
    public CommentaireManager getCommentaireManager() {
        return commentaireManager;
    }

    @Override
    public CommentaireSurTopoManager getCommentaireSurTopoManager() {
        return commentaireSurTopoManager;
    }

    @Override
    public EmpruntManager getEmpruntManager() {
        return empruntManager;
    }

    @Override
    public SecteurManager getSecteurManager() {
        return secteurManager;
    }

    @Override
    public SiteManager getSiteManager() {
        return siteManager;
    }

    @Override
    public TopoManager getTopoManager(){
        return topoManager;
    }

    @Override
    public UtilisateurManager getUtilisateurManager(){
        return utilisateurManager;
    }

    @Override
    public VoieManager getVoieManager() {
        return voieManager;
    }

    @Override
    public RechercheManager getRechercheManager(){
        return rechercheManager;
    }
}
