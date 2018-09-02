package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Named
//@Singleton
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    @Override
    public void create(Object model) {

        loadDatabase();
        Topo topo = (Topo) model;

        try {
            PreparedStatement preparedStatement = getConnexion().prepareStatement("INSERT INTO topo (auteur, titre, description) VALUES(?, ?, ?);");
            preparedStatement.setString(1, topo.getAuteur());
            preparedStatement.setString(2, topo.getTitre());
            preparedStatement.setString(3, topo.getDescription());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnexion();
    }

    @Override
    public Object get(int pId) {

        Topo topo = new Topo();
        ResultSet resultat = null;

        loadDatabase();

        try {
            PreparedStatement preparedStatement = getConnexion().prepareStatement("SELECT * FROM topo WHERE id = ?;");
            preparedStatement.setInt(1,pId);
            resultat = preparedStatement.executeQuery();


            // Récupération des données
            if (!resultat.next()) {
                System.out.println("Pas de données");
                throw new SQLException("Pas de données");
            } else {
                int id = resultat.getInt("id");
                String auteur = resultat.getString("auteur");
                String titre = resultat.getString("titre");
                String description = resultat.getString("description");

                topo.setId(id);
                topo.setAuteur(auteur);
                topo.setTitre(titre);
                topo.setDescription(description);

            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();

            } catch (SQLException ignore) {
            } finally{
                closeConnexion();
            }
        }
        return topo;
    }

    @Override
    public List list() {
//        String vSQL = "SELECT * FROM topo";
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
//        RowMapper<Topo> vRowMapper = new RowMapper<Topo>() {
//            public Topo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
//                Topo vTopo = new Topo(pRS.getInt("id"));
//                return vTopo;
//            }
//        };
//
//        List<Topo> vListStatut = jdbcTemplate.query(vSQL, vRowMapper);
//
//        return vListStatut;

        List<Topo> topos = new ArrayList<Topo>();


//        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

//        Connection connexion = this.getConnexion();
//        System.out.println("Connexion DB établie");

        try {
//            statement = connexion.createStatement();
            PreparedStatement preparedStatement = getConnexion().prepareStatement("SELECT * FROM topo;");
            // Exécution de la requête
            resultat = preparedStatement.executeQuery();
//            resultat = statement.executeQuery("SELECT * FROM topo;");

            // Récupération des données
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String auteur = resultat.getString("auteur");
                String titre = resultat.getString("titre");
                String description = resultat.getString("description");

                Topo topo = new Topo();

                topo.setId(id);
                topo.setAuteur(auteur);
                topo.setTitre(titre);
                topo.setDescription(description);

                topos.add(topo);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
            } catch (SQLException ignore) {
            } finally {
                closeConnexion();
            }
        }

        return topos;
    }

    @Override
    public void update(Object model) {
        System.out.println("hey");
        loadDatabase();
        Topo topo = (Topo) model;

        System.out.println("id = " + topo.getId() + "\n"
                + "titre = " + topo.getTitre() + "\n"
                + "description = " + topo.getDescription() + "\n"
                + "auteur = " + topo.getAuteur());

        System.out.println("------------------------------------------------------------------");
        try {
            PreparedStatement preparedStatement = getConnexion().prepareStatement("UPDATE topo SET (auteur, titre, description) = (?,?,?) WHERE id = ? ;");
            preparedStatement.setString(1, topo.getAuteur());
            preparedStatement.setString(2, topo.getTitre());
            preparedStatement.setString(3, topo.getDescription());
            preparedStatement.setInt(4, topo.getId());

            System.out.println("hey");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
            throw new NoSuchElementException();
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        loadDatabase();

        try {
            PreparedStatement preparedStatement = getConnexion().prepareStatement("DELETE FROM topo WHERE id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoSuchElementException();
        }

    }
}
