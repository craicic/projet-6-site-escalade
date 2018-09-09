package com.gg.proj.business.contract;

import com.gg.proj.business.contract.manager.SiteManager;
import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.business.contract.manager.UtilisateurManager;

public interface ManagerFactory {

    SiteManager getSiteManager();

    TopoManager getTopoManager();

    UtilisateurManager getUtilisateurManager();
}
