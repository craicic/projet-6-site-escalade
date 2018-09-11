package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.model.bean.Voie;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class GestionVoieAction extends ActionSupport {
    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Voie voie;
    private List<Voie> listVoie;
    private List<Secteur> listSecteur;

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

    public String doCreate() {
        String resultat = ActionSupport.INPUT;
        if(voie != null) {
                managerFactory.getVoieManager().create(voie);
                this.addActionMessage("Voie modifié : " + voie.getNom());
                resultat = ActionSupport.SUCCESS;
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
}
