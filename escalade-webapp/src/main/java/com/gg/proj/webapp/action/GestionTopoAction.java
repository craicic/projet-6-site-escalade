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

public class GestionTopoAction extends ActionSupport implements SessionAware {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    private ManagerFactory managerFactory;

    private Integer id;
    private List<Topo> listTopo;
    private Topo topo;
    private Site site;
    private Commentaire commentaire;
    private List<Commentaire> listCommentaire;
    private List<Site> listSite;
    private Map<String, Object> session;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<Topo> getListTopo() {
        return listTopo;
    }
    public void setListTopo(List<Topo> listTopo) {
        this.listTopo = listTopo;
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
    public List<Site> getListSite() {
        return listSite;
    }
    public void setListSite(List<Site> listSite) {
        this.listSite = listSite;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String doCreate() {
        // Si (this.topo == null) c'est que l'on entre dans l'ajout de topo
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le resultat est "input"
        String resultat = ActionSupport.INPUT;

        if (this.topo != null) {
            try {
                managerFactory.getTopoManager().create(this.topo);
        // Il nous faut récupéré l'id
                topo.setId(managerFactory.getTopoManager().getId(this.topo));
                this.addActionMessage("Topo ajouté.");
                resultat = ActionSupport.SUCCESS;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
                resultat = ActionSupport.ERROR;
            }
        }
        return resultat;
    }

    public String doList() {
        listTopo = managerFactory.getTopoManager().list();
        return ActionSupport.SUCCESS;
    }

    public String doDetail() {

        if (id == null) {
            this.addActionError("Vous devez indiquer un id de topo");
        } else {
            try {

                topo = managerFactory.getTopoManager().get(id);
                // La liste des sites associés au topo d'id topoId
                listSite = managerFactory.getTopoManager().listLinkedSite(id);
                listCommentaire = managerFactory.getTopoManager().listComments(id);
            } catch (NoSuchElementException e) {
                logger.error(e.getMessage());
                this.addActionError("Topo non trouvé. ID = " + id);
                ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String resultat = ActionSupport.INPUT;

        if (this.topo != null) {
            if (this.topo.getId() != null) {
                try {
                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                    Topo tmpTopo = managerFactory.getTopoManager().get(topo.getId());
                    tmpTopo.setTitre(topo.getTitre());
                    tmpTopo.setAuteur(topo.getAuteur());
                    tmpTopo.setDescription(topo.getDescription());
                    tmpTopo.setEmpreintable(topo.isEmpreintable());
                    managerFactory.getTopoManager().update(tmpTopo);
                } catch (NoSuchElementException e) {
                    ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                resultat = ActionSupport.SUCCESS;
            } else {
                this.addActionError("Id doit être défini");
                resultat = ActionSupport.ERROR;
            }
        } else {
            // Si topo est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur topo afin de pré-rempir les champs de la page web
            topo = managerFactory.getTopoManager().get(id);
        }
        return resultat;
    }

    public String doDelete() {
        try {
            managerFactory.getTopoManager().delete(this.id);
            this.addActionMessage("Topo supprimé.");
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
        managerFactory.getTopoManager().addComment(commentaire,id);
        return ActionSupport.SUCCESS;
    }


    public String doLinkSiteTopo() {
        String resultat = ActionSupport.INPUT;

        if (id == null){
            this.addActionError("Vous devez indiquer un id de topo");
            resultat = ActionSupport.ERROR;
        } else {
            if (topo != null){
                // On créé un objet CompositionSiteTopo
                CompositionSiteTopo compositionSiteTopo = new CompositionSiteTopo(topo.getId(),site.getId());
                // On sort du formulaire avec les infos sur le site associé, il faut maintenant entré envoyé ceci en back
                managerFactory.getTopoManager().setLink(compositionSiteTopo);
                // Il faut récupéré l'id du topo (pour la redirection)
                topo.setId(managerFactory.getTopoManager().getId(topo));
                resultat = ActionSupport.SUCCESS;
            } else {
                // On récupère la liste des site pour la boite de choix, il nous faut exlure les site déja associé a ce topo
                listSite = managerFactory.getSiteManager().listSiteNotLinked(id);
                topo = managerFactory.getTopoManager().get(id);
            }
        }
        return resultat;
    }
}
