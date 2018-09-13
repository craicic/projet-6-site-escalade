package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

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

                // Ajout de l'utilisateur en session
                this.session.put(utilisateur.getPseudo(), utilisateur);

                resultat = ActionSupport.SUCCESS;
            // NotFoundException n'était pas implémenté
            } catch (Exception e){
                this.addActionError("Identifiant ou mot de passe incorrect !");
            }
        }
        return resultat;
    }

    public String doLogout(){
        this.session.remove(identifiant);
        return ActionSupport.SUCCESS;
    }
}
