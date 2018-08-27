package com.gg.proj.webapp.action;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.business.impl.ManagerFactoryImpl;
import com.gg.proj.business.impl.manager.TopoManagerImpl;
import com.gg.proj.model.bean.Topo;
import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;
import java.util.List;

public class GestionTopoAction extends ActionSupport {


    @Inject
    private ManagerFactory managerFactory;

    private List<Topo> listTopo;
    private Topo topo;

    public List<Topo> getListTopo() {return listTopo;}
    public void setListTopo(List<Topo> listTopo) {this.listTopo = listTopo;}

    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public String doList(){

        listTopo = managerFactory.getTopoManager().list();

        System.out.println("listTopo.size() = " + listTopo.size());
        for (Topo instanceDeTopo : listTopo) {
            System.out.println( "id = " + instanceDeTopo.getId() + "\n"
                            +   "titre = " + instanceDeTopo.getTitre() + "\n"
                            +   "description = " + instanceDeTopo.getDescription() + "\n"
                            +   "auteur = " + instanceDeTopo.getAuteur());

        }
        return ActionSupport.SUCCESS;
    }
    public String doGetById(){

        //Spécifier un id
        int id = 1;

        topo = managerFactory.getTopoManager().get(id);
        System.out.println( "id = " + topo.getId() + "\n"
                +   "titre = " + topo.getTitre() + "\n"
                +   "description = " + topo.getDescription() + "\n"
                +   "auteur = " + topo.getAuteur());

        return ActionSupport.SUCCESS;
    }
}
