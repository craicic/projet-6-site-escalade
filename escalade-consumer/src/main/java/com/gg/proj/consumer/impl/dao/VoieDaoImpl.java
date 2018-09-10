package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.VoieDao;
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
        logger.debug("Entrée dans la méthode get avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM voie WHERE id = ?;",
                (rs, rowNum) -> {
                    Voie voie = new Voie();
                    voie.setId(rs.getInt("id"));
                    voie.setNom(rs.getString("nom"));
                    voie.setDescription(rs.getString("description"));
                    voie.setNombreDePoints(rs.getInt("nombre_points"));
                    voie.setNombreDeLongueurs(rs.getInt("nombre_longueurs"));
                    voie.setCotation(rs.getString("cotation"));
                    voie.setHauteur(rs.getString("hauteur"));
                    voie.setSecteurId(rs.getInt("secteur_id"));
                    return voie;
                },id);
    }

    @Override
    public List<Voie> list() {

        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM voie;",
                (rs, rowNum) -> {
                    Voie voie = new Voie();
                    voie.setId(rs.getInt("id"));
                    voie.setNom(rs.getString("nom"));
                    voie.setDescription(rs.getString("description"));
                    voie.setNombreDePoints(rs.getInt("nombre_points"));
                    voie.setNombreDeLongueurs(rs.getInt("nombre_longueurs"));
                    voie.setCotation(rs.getString("cotation"));
                    voie.setHauteur(rs.getString("hauteur"));
                    voie.setSecteurId(rs.getInt("secteur_id"));
                    return voie;
                });
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
}
