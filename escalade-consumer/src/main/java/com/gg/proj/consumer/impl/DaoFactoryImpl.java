package com.gg.proj.consumer.impl;

import com.gg.proj.consumer.contract.DaoFactory;
import com.gg.proj.consumer.contract.dao.TopoDao;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
//@Singleton
public class DaoFactoryImpl implements DaoFactory {

        @Inject
        private TopoDao topoDao;

        @Override
        public TopoDao getTopoDao()
        {
            return topoDao;
        }
}
