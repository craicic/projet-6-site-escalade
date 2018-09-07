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

    private Integer id;
    private List<Utilisateur> listUtilisateur;
    private Utilisateur utilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String doCreate() {
        String result = Action.INPUT;
        if (utilisateur != null) {
            try {
                managerFactory.getUtilisateurManager().create(utilisateur);
                result = Action.SUCCESS;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
                result = ActionSupport.ERROR;
            }
        }
        return result;
    }

    public String doDetail() {
        utilisateur = managerFactory.getUtilisateurManager().get(id);
        return Action.SUCCESS;
    }

    public String doList() {
        listUtilisateur = managerFactory.getUtilisateurManager().list();
        return Action.SUCCESS;
    }

    public String doUpdate(){
        return Action.SUCCESS;
    }

    public String doDelete() {
        managerFactory.getUtilisateurManager().delete(id);
        return Action.SUCCESS;
    }
}
