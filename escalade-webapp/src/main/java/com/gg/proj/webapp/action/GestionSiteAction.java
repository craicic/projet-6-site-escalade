package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class GestionSiteAction extends ActionSupport implements SessionAware {
    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Site site;
    private Integer siteId;
    private List<Site> listSite;
    private List<Secteur> listSecteur;
    private List<Topo> listTopo;
    private Commentaire commentaire;
    private List<Commentaire> listCommentaire;
    private Map<String, Object> session;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Site getSite() {
        return site;
    }
    public void setSite(Site site) {
        this.site = site;
    }
    public Integer getSiteId() {
        return siteId;
    }
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    public void setListSite(List<Site> listSite) {
        this.listSite = listSite;
    }
    public List<Secteur> getListSecteur() {
        return listSecteur;
    }
    public void setListSecteur(List<Secteur> listSecteur) {
        this.listSecteur = listSecteur;
    }
    public List<Topo> getListTopo() {
        return listTopo;
    }
    public void setListTopo(List<Topo> listTopo) {
        this.listTopo = listTopo;
    }
    public Commentaire getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }
    public List<Commentaire> getListCommentaire() {
        return listCommentaire;
    }
    public void setListCommentaire(List<Commentaire> listCommentaire) {
        this.listCommentaire = listCommentaire;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String doCreate() {
        String resultat = ActionSupport.INPUT;
        if(site != null) {
            try {
                managerFactory.getSiteManager().create(site);
                this.addActionMessage("Site ajouté : " + site.getNom());
                resultat = ActionSupport.SUCCESS;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
            }
        }
        return resultat;
    }

    public String doDetail() {
        if (id != null){
            site = managerFactory.getSiteManager().get(id);
            listSecteur = managerFactory.getSecteurManager().listLinkedSecteurBySiteId(id);
            listTopo = managerFactory.getTopoManager().listTopoBySiteId(id);
            listCommentaire = managerFactory.getSiteManager().listComments(id);
            return ActionSupport.SUCCESS;
        } else {
            addActionMessage("Id doit être défini");
            return ActionSupport.ERROR;
        }
    }

    public String doList() {
        listSite = managerFactory.getSiteManager().list();
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String resultat = ActionSupport.INPUT;
        if(site != null) {
            try {
                // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Site temporaire
                // Ainsi l'id est non modifiable.
                logger.info("hey");
                Site tmpSite = managerFactory.getSiteManager().get(site.getId());
                tmpSite.setNom(site.getNom());
                tmpSite.setDescription(site.getDescription());
                tmpSite.setProfil(site.getProfil());
                tmpSite.setRoche(site.getRoche());
                tmpSite.setType(site.getType());
                tmpSite.setCoordonneeX(site.getCoordonneeX());
                tmpSite.setCoordonneeY(site.getCoordonneeY());
                managerFactory.getSiteManager().update(tmpSite);
                this.addActionMessage("Site modifié : " + site.getNom());
                resultat = ActionSupport.SUCCESS;
            } catch (Exception e) {
                logger.info("exception " + e.getMessage());
                this.addActionError(e.getMessage());
            }
        } else {
            // Si site est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur site afin de pré-rempir les champs de la page web
            site = managerFactory.getSiteManager().get(id);
            logger.info("site.description : " + site.getDescription());
        }
        return resultat;
    }

    public String doDelete() {
        try {
            managerFactory.getSiteManager().delete(this.id);
            this.addActionMessage("Site supprimé");
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Action d'ajout de commentaires
     * @return ActionSupport
     */
    public String doAddComment(){
        // On récupère l'utilisateur en session
        Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("utilisateur");
        // Pour en récupérer l'id
        commentaire.setUtilisateurId(utilisateurEnSession.getId());
        //
        logger.info(commentaire.getId()+" "+commentaire.getContenuTexte()+" id = " + id);
        managerFactory.getSiteManager().addComment(commentaire,id);
        return ActionSupport.SUCCESS;
    }
}
