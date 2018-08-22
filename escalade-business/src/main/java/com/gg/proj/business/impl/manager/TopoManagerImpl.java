package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.TopoManager;
import com.gg.proj.consumer.contract.DaoFactory;
import com.gg.proj.consumer.impl.dao.TopoDaoImpl;
import com.gg.proj.model.bean.Topo;

import javax.inject.Inject;
import java.util.List;

public class TopoManagerImpl implements TopoManager {


    @Inject
    DaoFactory daoFactory;

    @Override
    public void create(Topo model) {
    }

    @Override
    public Topo get(int id) {
        return null;
    }

    @Override
    public List<Topo> list() {
        return daoFactory.getTopoDao().list();
    }

    @Override
    public void update(Topo model) {

    }

    @Override
    public void delete(Topo model) {

    }
}
