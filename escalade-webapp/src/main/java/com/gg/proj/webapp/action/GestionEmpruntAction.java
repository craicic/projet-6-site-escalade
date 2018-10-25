package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class GestionEmpruntAction extends ActionSupport implements SessionAware {
    private final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Topo topo;
    private List<Utilisateur> listPossesseur;
    private Map<String,Object> session;

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

    public List<Utilisateur> getListPossesseur() {
        return listPossesseur;
    }

    public void setListPossesseur(List<Utilisateur> listPossesseur) {
        this.listPossesseur = listPossesseur;
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

    public String doBorrow() {
        String result = ActionSupport.SUCCESS;
        listPossesseur = managerFactory.getEmpruntManager().listAllOnwersByTopoId(topo.getId());
        return result;
    }

    public String doManageMyLoan() {
        return ActionSupport.SUCCESS;
    }

    public String doSetBorrowingTime() {
        return ActionSupport.SUCCESS;
    }

    public String doMarkAsReservable() {
        Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("utilisateur");
        managerFactory.getEmpruntManager().setTopoOwner(topo.getId(), utilisateurEnSession.getId() );
        return ActionSupport.SUCCESS;
    }
}
