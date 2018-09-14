package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware {

    private static final Logger logger = LogManager.getLogger();
    @Inject
    ManagerFactory managerFactory;

    private String identifiant;
    private String motDePasse;
    private Map<String,Object> session;
    private HttpServletRequest servletRequest;

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
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.servletRequest = request;
    }

    /**
     * @return un String de l'enumération {@link ActionSupport}.
     */
    public String doLogin(){
        String resultat = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(identifiant,motDePasse)){
            try{
                // Recherche d'un utilisateur par couple identifiant, mot de passe
                Utilisateur utilisateur = managerFactory.getUtilisateurManager().get(identifiant, motDePasse);
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

    /**
     * @return un String de l'enumération {@link ActionSupport} toujours un success.
     */
    public String doLogout(){
        // Invalidation de la session utilisateur
        servletRequest.getSession().invalidate();
        return ActionSupport.SUCCESS;
    }
}
