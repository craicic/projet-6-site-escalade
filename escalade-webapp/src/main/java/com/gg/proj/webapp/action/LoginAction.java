package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private static final Logger logger = LogManager.getLogger();
    @Inject
    ManagerFactory managerFactory;

    private String identifiant;
    private String motDePasse;
    private Map<String,Object> session;

    public String getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String doLogin(){
        String resultat = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(identifiant,motDePasse)){
            try{
                Utilisateur utilisateur = managerFactory.getUtilisateurManager().get(identifiant, motDePasse);
                logger.info("utilisateur " + utilisateur.getPseudo());
                // Ajout de l'utilisateur en session
                this.session.put("utilisateur", utilisateur);

                resultat = ActionSupport.SUCCESS;
            // NotFoundException n'était pas implémenté
            } catch (Exception e){
                this.addActionError("Identifiant ou mot de passe incorrect ! " + e.getMessage());
            }
        }
        return resultat;
    }

    public String doLogout(){
        this.session.remove("utilisateur");
        return ActionSupport.SUCCESS;
    }
}
