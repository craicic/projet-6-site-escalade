package com.gg.proj.consumer.impl.dao;

import javax.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDaoImpl {



    @Inject
    private Connection connexion;

    @Inject
    private DataSource dataSource;

    protected DataSource getDataSource(){
        return dataSource;
    }

    protected Connection getConnexion() {
        return connexion;
    }

    protected void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
