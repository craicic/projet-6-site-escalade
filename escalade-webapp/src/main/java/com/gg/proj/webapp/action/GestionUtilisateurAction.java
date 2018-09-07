package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GestionUtilisateurAction extends ActionSupport {

    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private List<Utilisateur> listUtilisateur;
    private Utilisateur utilisateur;

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public String doList() {
        listUtilisateur = managerFactory.getUtilisateurManager().list();
        return Action.SUCCESS;
    }

    public String doDelete(){
        return Action.SUCCESS;
    }

}
