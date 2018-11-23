package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Commentaire;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.model.bean.Utilisateur;
import com.gg.proj.model.bean.Voie;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.expression.ExpressionException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class GestionVoieAction extends ActionSupport implements SessionAware {
    private final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Voie voie;
    private Secteur secteur;
    private Integer secteurId;
    private List<Voie> listVoie;
    private List<Secteur> listSecteur;
    private List<Commentaire> listCommentaire;
    private Commentaire commentaire;
    private Map<String, Object> session;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Voie getVoie() {
        return voie;
    }
    public void setVoie(Voie voie) {
        this.voie = voie;
    }
    public Secteur getSecteur() {
        return secteur;
    }
    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    public Integer getSecteurId() {
        return secteurId;
    }
    public void setSecteurId(Integer secteurId) {
        this.secteurId = secteurId;
    }
    public List<Voie> getListVoie() {
        return listVoie;
    }
    public void setListVoie(List<Voie> listVoie) {
        this.listVoie = listVoie;
    }
    public List<Secteur> getListSecteur() {
        return listSecteur;
    }
    public void setListSecteur(List<Secteur> listSecteur) {
        this.listSecteur = listSecteur;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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

    public String doCreate() {
        String resultat = ActionSupport.INPUT;
        if(voie != null) {
                try {
                    managerFactory.getVoieManager().create(voie, secteurId);
                    this.addActionMessage("Voie créée : " + voie.getNom());
                    resultat = ActionSupport.SUCCESS;
                } catch (ExpressionException e){
                    this.addActionError(e.getMessage());
                    resultat = ActionSupport.ERROR;
                }
        } else {
            // On rempli listSecteur pour le menu Select
            listSecteur = managerFactory.getSecteurManager().list();
        }
        return resultat;
    }

    public String doDetail() {
        if (id == null) {
        this.addActionError("Vous devez indiquer un id de voie");
    } else {
        try {
            voie = managerFactory.getVoieManager().get(id);
            // Uniquement le nom de secteur sera connu
            secteur = managerFactory.getSecteurManager().getLinkedSecteurByVoieId(id);
            listCommentaire = managerFactory.getVoieManager().listComments(id);
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            this.addActionError("Voie non trouvée. ID = " + id);
            ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doList() {
        listVoie = managerFactory.getVoieManager().list();
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String resultat = ActionSupport.INPUT;
        if(voie != null) {
            try {
                // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie une voie temporaire
                // Ainsi l'id est non modifiable.
                Voie tmpVoie = managerFactory.getVoieManager().get(voie.getId());
                tmpVoie.setNom(voie.getNom());
                tmpVoie.setDescription(voie.getDescription());
                tmpVoie.setNombreDePoints(voie.getNombreDePoints());
                tmpVoie.setNombreDeLongueurs(voie.getNombreDeLongueurs());
                tmpVoie.setCotation(voie.getCotation());
                tmpVoie.setHauteur(voie.getHauteur());
                tmpVoie.setSecteurId(voie.getSecteurId());
                managerFactory.getVoieManager().update(tmpVoie);
                this.addActionMessage("Voie modifié : " + voie.getNom());
                resultat = ActionSupport.SUCCESS;

            } catch (ExpressionException eE) {
              this.addActionError(eE.getMessage());
              resultat = ActionSupport.ERROR;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
            }
        } else {
            // Si voie est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur voie afin de pré-rempir les champs de la page web
            // On rempli listSecteur pour le menu Select
            listSecteur = managerFactory.getSecteurManager().list();
            voie = managerFactory.getVoieManager().get(id);
        }
        return resultat;
    }

    public String doDelete() {
        managerFactory.getVoieManager().delete(id);
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
        managerFactory.getVoieManager().addComment(commentaire,id);
        return ActionSupport.SUCCESS;
    }
}
