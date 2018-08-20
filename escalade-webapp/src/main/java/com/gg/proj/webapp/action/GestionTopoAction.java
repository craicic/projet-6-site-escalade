package com.gg.proj.webapp.action;

import com.gg.proj.business.impl.manager.TopoManagerImpl;
import com.gg.proj.model.bean.Topo;
import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;
import java.util.List;

public class GestionTopoAction extends ActionSupport {


    @Inject
    private TopoManagerImpl vTopoManagerImpl;

    private List<Topo> listTopo;


    public List<Topo> getListTopo() {return listTopo;}

    public String doList(){
        listTopo = vTopoManagerImpl.list();
        return ActionSupport.SUCCESS;
    }
}
