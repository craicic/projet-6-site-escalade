package com.gg.proj.business.impl.manager;

import com.gg.proj.business.contract.manager.TopoManager;
//import com.gg.proj.consumer.contract.DaoFactory;

import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.consumer.impl.dao.TopoDaoImpl;
import com.gg.proj.model.bean.Topo;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Named
public class TopoManagerImpl implements TopoManager {

    /*
    *
    * Je liste toutes les classes injectable
    *
     **/

    @Inject
    TopoDao TopoDao;

//    @Inject
//    private Connection connexion;

//    @Inject
//    private DataSource dataSource;


    @Override
    public void create(Topo model) {
        TopoDao.create(model);
    }

    @Override
    public Topo get(int id) {
        return (Topo)TopoDao.get(id);
    }

    @Override
    public List<Topo> list() {
        return TopoDao.list();
    }

    @Override
    public void update(Topo model) {

    }

    @Override
    public void delete(Integer id) {
        TopoDao.delete(id);
    }
}
