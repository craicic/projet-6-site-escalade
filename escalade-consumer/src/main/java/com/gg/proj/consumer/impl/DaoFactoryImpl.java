package com.gg.proj.consumer.impl;

import com.gg.proj.consumer.contract.DaoFactory;
import com.gg.proj.consumer.contract.dao.TopoDao;

import javax.inject.Inject;

public class DaoFactoryImpl implements DaoFactory {

    @Inject
    private TopoDao topoDao;

    @Override
    public TopoDao getTopoDao() { return topoDao;}

}
