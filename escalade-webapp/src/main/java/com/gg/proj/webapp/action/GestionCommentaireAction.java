package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GestionCommentaireAction extends ActionSupport {
    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Commentaire commentaire;
    private Utilisateur utilisateur;
    private Model objectType;

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
    public Model getObjectType() {
        return objectType;
    }
    public void setObjectType(Model objectType) {
        this.objectType = objectType;
    }

    public String doCreate() {
        commentaire.setUtilisateurId(utilisateur.getId());
        managerFactory.getCommentaireManager().create(commentaire);
        if (objectType.getClass() == Topo.class){
            CommentaireSurTopo commentaireSurTopo = new CommentaireSurTopo();
            commentaireSurTopo.setTopoId(objectType.getId());
            commentaireSurTopo.setCommentaireId(commentaire.getId());
            managerFactory.getCommentaireSurTopoManager().create(commentaireSurTopo);
        }
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
        return ActionSupport.SUCCESS;
    }
}
