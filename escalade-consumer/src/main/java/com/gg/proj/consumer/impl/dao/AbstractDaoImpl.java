package com.gg.proj.consumer.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.management.remote.rmi.RMIConnectionImpl;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDaoImpl {


    private Connection connexion;

    @Inject
    private DataSource dataSource;

    protected DataSource getDataSource(){
        return dataSource;
    }

    protected Connection getConnexion() {
        return connexion;
    }

}
