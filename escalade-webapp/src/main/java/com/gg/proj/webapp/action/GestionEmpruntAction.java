package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.Action;
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
    private Map<String,Object> session;
    private List<Topo> listAvailableTopo;
    private List<Topo> listLoanedTopo;
    private List<Topo> listBorrowedTopo;

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

    public String doListAvailable(){
        listAvailableTopo = managerFactory.getEmpruntManager().listAvailableTopo();
        return ActionSupport.SUCCESS;
    }

    public String doBorrow() {
        String result = ActionSupport.SUCCESS;
        return result;
    }

    public String doManageMyLoan() {
        Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("utilisateur");

        // On récupère les liste de topo en prèt et en emprunt
//        listBorrowedTopo = managerFactory.getEmpruntManager().listBorrowedTopo(utilisateurEnSession.getId());
//        listEmprunt = managerFactory.getEmpruntManager().listEmprunt(utilisateurEnSession.getId());
//        listEmpruntInfo = managerFactory.getEmpruntManager().getEmpruntInfo(utilisateurEnSession.getId());
//        listLoanedTopo = managerFactory.getEmpruntManager().getLoanedTopo(utilisateurEnSession.getId());
//        listProprieteTopo =
//        // On récupère les date de fin de prêt
//        listEmprunt = managerFactory.getEmpruntManager().listEmpruntByUserId(utilisateurEnSession.getId());

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
