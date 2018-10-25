package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.model.bean.Topo;
import com.gg.proj.model.bean.Utilisateur;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GestionEmpruntAction extends ActionSupport {
    private final static Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    private Integer id;
    private Topo topo;
    private List<Utilisateur> listPossesseur;

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

    public String doCheck() {
        return "success";
    }

    public String doSetBorrowingTime() throws Exception {
        return "success";
    }
}
