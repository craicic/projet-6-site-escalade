package com.gg.proj.business.impl;

import com.gg.proj.business.contract.ManagerFactory;
import com.gg.proj.business.contract.manager.TopoManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private TopoManager topoManager;

    @Override
    public TopoManager getTopoManager(){
        System.out.println("Hey from TopoManagerImpl");
        return topoManager;
    }
}
