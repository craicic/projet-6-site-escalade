package com.gg.proj.business.contract;

import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.business.contract.manager.UtilisateurManager;

public interface ManagerFactory {

    TopoManager getTopoManager();

    UtilisateurManager getUtilisateurManager();
}
