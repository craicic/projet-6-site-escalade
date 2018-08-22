package com.gg.proj.consumer.contract;

import com.gg.proj.consumer.contract.dao.TopoDao;

public interface DaoFactory {

    TopoDao getTopoDao();
}
