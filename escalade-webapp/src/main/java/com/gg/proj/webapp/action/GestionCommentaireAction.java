package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.NoSuchElementException;

public class GestionCommentaireAction extends ActionSupport implements SessionAware {
    private final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Topo topo;
    private Site site;
    private Voie voie;
    private String actionName;
    private Commentaire commentaire;
    private Utilisateur utilisateur;
    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String doCreate() {
        return ActionSupport.SUCCESS;
    }

    public String doDetail() {
        return ActionSupport.SUCCESS;
    }

    public String doList() {
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        return ActionSupport.SUCCESS;
    }

    public String doDelete() {
        try {
            managerFactory.getCommentaireManager().delete(this.id);
            this.addActionMessage("Message supprimé.");
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode d'édition de ses propres commentaires
     * @return  ActionSupport
     */
    public String doUpdateMyComment() {
        String resultat = ActionSupport.INPUT;
        if (this.commentaire != null){
            Commentaire tmpCommentaire = managerFactory.getCommentaireManager().get(commentaire.getId());
            tmpCommentaire.setContenuTexte(commentaire.getContenuTexte());
            managerFactory.getCommentaireManager().update(tmpCommentaire);
            resultat = ActionSupport.SUCCESS;
        } else {
            logger.info("Passage dans get");
            // On vérifie que l'utilisateur est connecté
            Commentaire tmpCommentaire = managerFactory.getCommentaireManager().get(this.id);
            Utilisateur tmpUtilisateur = (Utilisateur) session.get("utilisateur");
            // On inscrit dans une variable l'action dans laquelle on se trouve.
            // Ceci nous permettra d'appeler l'action adéquate quand nous serons dans la jsp update_my_comment (factorisation)
            actionName = ActionContext.getContext().getName();
            if ( tmpUtilisateur.getId() == tmpCommentaire.getUtilisateurId() ) {
                // Si le commentaire est nul, on va charger le contenu du commentaire
                commentaire = tmpCommentaire;
            } else {
                addActionError("Accès illegal");
                resultat = ActionSupport.ERROR;
            }
        }
        return resultat;
    }
}
