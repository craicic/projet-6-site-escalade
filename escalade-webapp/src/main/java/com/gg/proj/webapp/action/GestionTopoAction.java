package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Topo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class GestionTopoAction extends ActionSupport {

    private static final Logger logger = LogManager.getLogger();

    @Inject
    private ManagerFactory managerFactory;

    private Integer id;
    private List<Topo> listTopo;
    private Topo topo;

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

    public String doCreate() {
        // Si (this.topo == null) c'est que l'on entre dans l'ajout de topo
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (this.topo != null) {
            try {
                managerFactory.getTopoManager().create(this.topo);
                this.addActionMessage("Topo ajouté.");
                vResult = ActionSupport.SUCCESS;
            } catch (Exception e) {
                logger.error(e.getMessage());
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
        }
        return vResult;
    }

    public String doList() {
        listTopo = managerFactory.getTopoManager().list();
        return ActionSupport.SUCCESS;
    }

    public String doDetail() {

        // todo générer les exceptions

        if (id == null) {
            this.addActionError("Vous devez indiquer un id de topo");
        } else {
            try {
                topo = managerFactory.getTopoManager().get(id);
            } catch (NoSuchElementException e) {
                logger.error(e.getMessage());
                this.addActionError("Topo non trouvé. ID = " + id);
                ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (this.topo != null) {
            if (topo.getId() != null) {
                try {
                    // Le formulaire a été envoyé, afin d'éviter la manipulation des données via le navigateur, on instancie un Topo temporaire
                    // Ainsi l'id est non modifiable.
                    Topo tmpTopo = managerFactory.getTopoManager().get(topo.getId());
                    tmpTopo.setTitre(topo.getTitre());
                    tmpTopo.setAuteur(topo.getAuteur());
                    tmpTopo.setDescription(topo.getDescription());
                    managerFactory.getTopoManager().update(tmpTopo);
                } catch (NoSuchElementException e) {
                    ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                vResult = ActionSupport.SUCCESS;
            } else {
                addActionError("Id doit être défini");
                vResult = ActionSupport.ERROR;
            }
        } else {
            // Si topo est null c'est qu'on va entrer sur la jsp update.jsp, il faut embarquer les données sur topo afin de pré-rempir les champs de la page web
            topo = managerFactory.getTopoManager().get(id);
        }
        return vResult;
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

}
