package com.gg.proj.business.impl;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.business.contract.manager.TopoManager;

import javax.inject.Inject;

public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private TopoManager topoManager;

    @Override
    public TopoManager getTopoManager(){
        return topoManager;
    }
}
