package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Topo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
//@Singleton
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Object model) {

        Topo topo = (Topo) model;
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        try {
            jdbcTempplate.update("INSERT INTO topo (auteur, titre, description) VALUES(?, ?, ?);",
                    topo.getAuteur(),
                    topo.getTitre(),
                    topo.getDescription()
            );
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
        }

//        Ancienne méthode, avec PreparedStatement
//
//        loadDatabase();
//        Topo topo = (Topo) model;
//
//        try {
//            PreparedStatement preparedStatement = getConnexion().prepareStatement("INSERT INTO topo (auteur, titre, description) VALUES(?, ?, ?);");
//            preparedStatement.setString(1, topo.getAuteur());
//            preparedStatement.setString(2, topo.getTitre());
//            preparedStatement.setString(3, topo.getDescription());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        closeConnexion();




    }

    // todo : question faut-il utiliser Object ou Topo
    @Override
    public Object get(int id) {

        logger.debug("Entrée dans la méthode get avec l'id " + id);

        Topo topo = new Topo();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            topo = jdbcTemplate.queryForObject("SELECT * FROM topo WHERE id = ?;",
                    // RowMapper<T> ecrit via lambda
                    (rs, rowNum) ->{
                        Topo t = new Topo();
                        t.setId(rs.getInt("id"));
                        t.setTitre(rs.getString("Titre"));
                        t.setAuteur(rs.getString("Auteur"));
                        t.setDescription(rs.getString("Description"));
                        return t;
                    },
                    id // Paramètre ? de la requête :
            );
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
        }
        return topo;

    }

    @Override
    public List list() {

        List<Topo> topos = new ArrayList<Topo>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            topos = jdbcTemplate.query("SELECT * FROM topo;",
                    (rs, rowNum) -> {
                        Topo t = new Topo();
                        t.setId(rs.getInt("id"));
                        t.setTitre(rs.getString("Titre"));
                        t.setAuteur(rs.getString("Auteur"));
                        t.setDescription(rs.getString("Description"));
                        return t;
                    });
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
        }
        return topos;

        //        Ancienne méthode, avec PreparedStatement
//
//        ResultSet resultat = null;
//
//        loadDatabase();
//
//        try {
//            PreparedStatement preparedStatement = getConnexion().prepareStatement("SELECT * FROM topo;");
//            // Exécution de la requête
//            resultat = preparedStatement.executeQuery();
//
//            // Récupération des données
//            while (resultat.next()) {
//                int id = resultat.getInt("id");
//                String auteur = resultat.getString("auteur");
//                String titre = resultat.getString("titre");
//                String description = resultat.getString("description");
//
//                Topo topo = new Topo();
//
//                topo.setId(id);
//                topo.setAuteur(auteur);
//                topo.setTitre(titre);
//                topo.setDescription(description);
//
//                topos.add(topo);
//            }
//        } catch (SQLException e) {
//        } finally {
//            // Fermeture de la connexion
//            try {
//                if (resultat != null)
//                    resultat.close();
//            } catch (SQLException ignore) {
//            } finally {
//                closeConnexion();
//            }
//        }
//

    }

    @Override
    public void update(Object model) {

        Topo topo = (Topo) model;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            jdbcTemplate.update("UPDATE topo SET (auteur, titre, description) = (?,?,?) WHERE id = ? ;",
                    topo.getAuteur(),
                    topo.getTitre(),
                    topo.getDescription(),
                    topo.getId()
                    );
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
//            throw new SQLException(e.getMessage());
        }
//                Ancienne méthode, avec PreparedStatement
//
//        try {
//            PreparedStatement preparedStatement = getConnexion().prepareStatement("UPDATE topo SET (auteur, titre, description) = (?,?,?) WHERE id = ? ;");
//            preparedStatement.setString(1, topo.getAuteur());
//            preparedStatement.setString(2, topo.getTitre());
//            preparedStatement.setString(3, topo.getDescription());
//            preparedStatement.setInt(4, topo.getId());
//
//            System.out.println("hey");
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.getMessage();
//            throw new NoSuchElementException();
//        }
//
//        closeConnexion();
    }

    @Override
    public void delete(Integer id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            jdbcTemplate.update("DELETE FROM topo WHERE id = ?;",
                    id);
        } catch (DataAccessException e) {
            logger.error(e.getMessage());
        }

        //        Ancienne méthode, avec PreparedStatement
//
//        loadDatabase();
//
//        try {
//            PreparedStatement preparedStatement = getConnexion().prepareStatement("DELETE FROM topo WHERE id = ?;");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new NoSuchElementException();
//        }
//
//        closeConnexion();

    }
}
