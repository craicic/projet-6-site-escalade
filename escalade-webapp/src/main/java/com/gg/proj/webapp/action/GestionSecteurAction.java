package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Secteur;
import com.gg.proj.model.bean.Site;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class GestionSecteurAction extends ActionSupport {
    private final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Secteur secteur;
    private List<Secteur> listSecteur;
    private List<Site> listSite;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Secteur getSecteur() {
        return secteur;
    }
    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
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

    public String doCreate() {
        String result = ActionSupport.INPUT;
        if(secteur != null){
            managerFactory.getSecteurManager().create(secteur);
            result = ActionSupport.SUCCESS;
        } else
            // On rempli listSite afin de remplir la combobox de la page create
            listSite = managerFactory.getSiteManager().list();
        return result;
    }

    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de secteur");
        } else {
            try {
        secteur = managerFactory.getSecteurManager().get(id);
            } catch (NoSuchElementException e) {
                logger.error(e.getMessage());
                this.addActionError("Secteur non trouvé. ID = " + id);
                ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doList() {
        listSecteur = managerFactory.getSecteurManager().list();
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String resultat = ActionSupport.INPUT;
        if(secteur != null) {
            try {
                // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Site temporaire
                // Ainsi l'id est non modifiable.
                Secteur tmpSecteur = managerFactory.getSecteurManager().get(secteur.getId());
                tmpSecteur.setNom(secteur.getNom());
                tmpSecteur.setDescription(secteur.getDescription());
                tmpSecteur.setCoordonneesGPS(secteur.getCoordonneesGPS());
                tmpSecteur.setSiteId(secteur.getSiteId());
                managerFactory.getSecteurManager().update(tmpSecteur);
                this.addActionMessage("Secteur modifié : " + secteur.getNom());
                resultat = ActionSupport.SUCCESS;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
            }
        } else {
            // Si secteur est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur secteur afin de pré-rempir les champs de la page web
            listSite = managerFactory.getSiteManager().list();
            secteur = managerFactory.getSecteurManager().get(id);
        }
        return resultat;
    }

    public String doDelete() {
        managerFactory.getSecteurManager().delete(id);
        return ActionSupport.SUCCESS;
    }
}
