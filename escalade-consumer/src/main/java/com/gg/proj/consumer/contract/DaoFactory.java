package com.gg.proj.consumer.contract;

import com.gg.proj.consumer.contract.dao.TopoDao;

import javax.inject.Named;

@Named
public interface DaoFactory {

    TopoDao getTopoDao();
}
