package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.VoieDao;
import com.gg.proj.consumer.impl.rowmapper.VoieRM;
import com.gg.proj.model.bean.Voie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Voie model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO voie (nom,description,nombre_points,nombre_longueurs,cotation,hauteur,secteur_id) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?);",
                model.getNom(),
                model.getDescription(),
                model.getNombreDePoints(),
                model.getNombreDeLongueurs(),
                model.getCotation(),
                model.getHauteur(),
                model.getSecteurId()
        );
    }

    @Override
    public Voie get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();
        return jdbcTemplate.queryForObject("SELECT * FROM voie WHERE id = ?;", voieRM, id);
    }

    @Override
    public List<Voie> list() {

        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();
        return jdbcTemplate.query("SELECT * FROM voie;", voieRM);
    }

    @Override
    public void update(Voie model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE voie SET (nom,description,nombre_points,nombre_longueurs,cotation,hauteur,secteur_id) = (?,?,?,?,?,?,?) WHERE id = ?;",
                model.getNom(),
                model.getDescription(),
                model.getNombreDePoints(),
                model.getNombreDeLongueurs(),
                model.getCotation(),
                model.getHauteur(),
                model.getSecteurId(),
                model.getId());
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM voie WHERE id = ?;", id);
    }

    /**
     * Fonction qui va accéder à la BDD avec une requête LIKE
     *
     * @param termeDeLaRecherche
     * @return les voies qui correspondent
     */
    @Override
    public List<Voie> search(String termeDeLaRecherche) {
        logger.debug("Entrée dans la méthode search avec comme terme de recherche : " + termeDeLaRecherche);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        VoieRM voieRM = new VoieRM();
        String SQL = "SELECT DISTINCT * FROM voie v WHERE " +
                "v.nom LIKE \'%" + termeDeLaRecherche + "%\' " +
                "OR v.description LIKE \'%" + termeDeLaRecherche +"%\' ;";
        return jdbcTemplate.query(SQL, voieRM);
    }
}
