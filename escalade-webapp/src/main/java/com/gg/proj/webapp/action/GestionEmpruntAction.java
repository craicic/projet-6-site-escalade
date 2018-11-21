package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Emprunt;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GestionEmpruntAction extends ActionSupport implements SessionAware {
    private final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Topo topo;
    private boolean post;
    private Date date;
    private Map<String,Object> session;
    private List<Topo> listAvailableTopo;
    private List<Topo> listLoanedTopo;
    private List<Topo> listBorrowedTopo;
    private List<Emprunt> listEmprunt;

    // Getters & Setters
    @Override
    public void setSession(Map<String, Object> session){
      this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Topo> getListAvailableTopo() {
        return listAvailableTopo;
    }

    public void setListAvailableTopo(List<Topo> listAvailableTopo) {
        this.listAvailableTopo = listAvailableTopo;
    }

    public List<Topo> getListLoanedTopo() {
        return listLoanedTopo;
    }

    public void setListLoanedTopo(List<Topo> listLoanedTopo) {
        this.listLoanedTopo = listLoanedTopo;
    }

    public List<Topo> getListBorrowedTopo() {
        return listBorrowedTopo;
    }

    public void setListBorrowedTopo(List<Topo> listBorrowedTopo) {
        this.listBorrowedTopo = listBorrowedTopo;
    }

    public List<Emprunt> getListEmprunt() {
        return listEmprunt;
    }

    public void setListEmprunt(List<Emprunt> listEmprunt) {
        this.listEmprunt = listEmprunt;
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
        return ActionSupport.SUCCESS;
    }

    public String doListAvailable() {
        listAvailableTopo = managerFactory.getEmpruntManager().listAvailableTopo();
        return ActionSupport.SUCCESS;
    }

    public String doBorrow() {
        String result = ActionSupport.INPUT;
/*        if (!isPost()) {
            listEmprunt = managerFactory.getEmpruntManager().listEmpruntByTopoId(topo.getId());
            result = ActionSupport.SUCCESS;
        } else {*/

        if (date != null) {
            Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("utilisateur");

            Emprunt emprunt = new Emprunt();
            emprunt.setUtilisateurId(utilisateurEnSession.getId());
            // todo gestion topoId
            emprunt.setTopoId(topo.getId());

            managerFactory.getEmpruntManager().create(emprunt, date);

            result = ActionSupport.SUCCESS;
        } else {
            listEmprunt = managerFactory.getEmpruntManager().listEmpruntByTopoId(topo.getId());
        }
        return result;
    }

    public String doManageMyLoan() {
        Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("utilisateur");

        listBorrowedTopo = managerFactory.getEmpruntManager().listBorrowedTopo(utilisateurEnSession.getId());
        listLoanedTopo = managerFactory.getEmpruntManager().listLoanedTopo(utilisateurEnSession.getId());
        return ActionSupport.SUCCESS;
    }
}
