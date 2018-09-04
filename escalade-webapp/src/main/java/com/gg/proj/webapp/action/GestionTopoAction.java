package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Topo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class GestionTopoAction extends ActionSupport {


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

    public String doList() {

        listTopo = managerFactory.getTopoManager().list();

        System.out.println("listTopo.size() = " + listTopo.size());
//        for (Topo instanceDeTopo : listTopo) {
//            System.out.println("id = " + instanceDeTopo.getId() + "\n"
//                    + "titre = " + instanceDeTopo.getTitre() + "\n"
//                    + "description = " + instanceDeTopo.getDescription() + "\n"
//                    + "auteur = " + instanceDeTopo.getAuteur());
//        }
        return ActionSupport.SUCCESS;
    }

    public String doDetail() {

        // Todo générer les exceptions

        if (id == null) {
            this.addActionError("Vous devez indiquer un id de projet");
        } else {
            try {
                topo = managerFactory.getTopoManager().get(id);
            } catch (Exception e) {
                this.addActionError("Projet non trouvé. ID = " + id);
            }
        }
//        if(topo != null) {
//            System.out.println("id = " + topo.getId() + "\n"
//                    + "titre = " + topo.getTitre() + "\n"
//                    + "description = " + topo.getDescription() + "\n"
//                    + "auteur = " + topo.getAuteur());
//        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doCreate() {
        // Si (this.topo == null) c'est que l'on entre dans l'ajout de projet
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        if (this.topo != null) {
            try {
                managerFactory.getTopoManager().create(this.topo);
                this.addActionMessage("Topo ajouté.");
                vResult = ActionSupport.SUCCESS;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
        }
        return vResult;
    }

    public String doDelete() {
        try {
            managerFactory.getTopoManager().delete(this.id);
            this.addActionMessage("Topo supprimé.");
        } catch (NoSuchElementException e) {
            ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String vResult = ActionSupport.INPUT;
        System.out.println(vResult + " " + id);

        if (this.topo != null) {
//            if (id != null) {
                try {
//                System.out.println(id);
//                topo.setId(id);
                    managerFactory.getTopoManager().update(this.topo);
                } catch (NoSuchElementException e) {
                    ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                vResult = ActionSupport.SUCCESS;
//            }
//            else {
//                addActionError("id doit être défini");
//                vResult = ActionSupport.ERROR;
//            }
        }
        return vResult;
    }
}
