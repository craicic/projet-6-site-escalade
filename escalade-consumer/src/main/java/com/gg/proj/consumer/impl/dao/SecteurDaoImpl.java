package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.SecteurDao;
import com.gg.proj.model.bean.Secteur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.geometric.PGpoint;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Secteur model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO secteur (nom, decription, coordonnees_gps, site_id)  VALUES(?, ?, ?, ?);",
                model.getNom(),
                model.getDescription(),
                model.getCoordonneesGPS(),
                model.getSiteId()
        );
    }

    @Override
    public Secteur get(int id) {
        logger.debug("Entrée dans la méthode get avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM secteur WHERE id = ?;",
                (rs, rowNum) -> {
                    Secteur secteur = new Secteur();
                    secteur.setId(rs.getInt("id"));
                    secteur.setNom(rs.getString("nom"));
                    secteur.setDescription(rs.getString("decription"));
                    secteur.setCoordonneesGPS((PGpoint) rs.getObject("coordonnees_gps"));
                    secteur.setSiteId(rs.getInt("site_id"));
                    return secteur;
                },
                id);
    }

    @Override
    public List<Secteur> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM secteur;",
                (rs, rowNum) -> {
                    Secteur secteur = new Secteur();
                    secteur.setId(rs.getInt("id"));
                    secteur.setNom(rs.getString("nom"));
                    secteur.setDescription(rs.getString("decription"));
                    secteur.setCoordonneesGPS((PGpoint) rs.getObject("coordonnees_gps"));
                    secteur.setSiteId(rs.getInt("site_id"));
                    return secteur;
                });
    }

    @Override
    public void update(Secteur model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE secteur SET (nom,decription,coordonnees_gps,site_id) = (?,?,?,?) WHERE id = ?;",
                model.getNom(),
                model.getDescription(),
                model.getCoordonneesGPS(),
                model.getSiteId(),
                model.getId());
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM secteur WHERE id = ?;", id);
    }

    /**
     * Cette méthode renvoit la liste des secteurs associé au site d'id siteId
     * @param siteId
     * @return la liste des secteurs
     */
    @Override
    public List<Secteur> getBySiteId(Integer siteId){
        logger.debug("Entrée dans la méthode getBySiteId avec le siteId : " + siteId);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM secteur WHERE site_id = ?;",
                (rs, rowNum) -> {
                    Secteur secteur = new Secteur();
                    secteur.setId(rs.getInt("id"));
                    secteur.setNom(rs.getString("nom"));
                    secteur.setDescription(rs.getString("decription"));
                    secteur.setCoordonneesGPS((PGpoint) rs.getObject("coordonnees_gps"));
                    secteur.setSiteId(rs.getInt("site_id"));
                    return secteur;
                },
                siteId);
    }
}
