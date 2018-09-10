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
    public final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Secteur secteur;
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

    public String doCreate() {
        String result = ActionSupport.INPUT;
        if(secteur != null){
            managerFactory.getSecteurManager().create(secteur);
            result = ActionSupport.SUCCESS;
        } else
            listSite = managerFactory.getSiteManager().list();
        return result;
    }

    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de topo");
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
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        return ActionSupport.SUCCESS;
    }

    public String doDelete() {
        return ActionSupport.SUCCESS;
    }
}
