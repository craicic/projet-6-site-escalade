package com.gg.proj.consumer.impl.dao;

import javax.sql.DataSource;

public abstract class AbstractDaoImpl {
    private DataSource dataSource;

    protected DataSource getDataSource(){
        return dataSource;
    }
}
