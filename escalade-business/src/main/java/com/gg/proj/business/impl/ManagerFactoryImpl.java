package com.gg.proj.business.impl;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.business.contract.manager.SiteManager;
import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.business.contract.manager.UtilisateurManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private SiteManager siteManager;

    @Inject
    private TopoManager topoManager;

    @Inject
    private UtilisateurManager utilisateurManager;


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

}
