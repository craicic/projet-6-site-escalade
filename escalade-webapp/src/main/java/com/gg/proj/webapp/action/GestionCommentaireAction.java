package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

public class GestionCommentaireAction extends ActionSupport {
    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Commentaire commentaire;
    private Utilisateur utilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
            // Si le commentaire est nul, on va charger le contenu du commentaire
            commentaire = managerFactory.getCommentaireManager().get(this.id);
        }
        return resultat;
    }
}
