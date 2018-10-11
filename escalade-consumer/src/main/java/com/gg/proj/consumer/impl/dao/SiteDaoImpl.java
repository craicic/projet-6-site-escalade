package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.SiteDao;
import com.gg.proj.consumer.impl.rowmapper.SiteRM;
import com.gg.proj.model.bean.Site;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.geometric.PGpoint;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Site model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("INSERT INTO site (nom, description, profil, roche, type, coordonnees_gps) VALUES (?,?,?,?,?,?);",
                model.getNom(),
                model.getDescription(),
                model.getProfil(),
                model.getRoche(),
                model.getType(),
                model.getCoordonneesGPS()
        );
    }

    @Override
    public Site get(int id) {
        logger.debug("Entrée dans la méthode getByUserPseudo avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        return jdbcTemplate.queryForObject("SELECT * FROM site WHERE id = ?;", siteRM, id);
    }

    @Override
    public List<Site> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        SiteRM siteRM = new SiteRM();
        return jdbcTemplate.query("SELECT * FROM site;", siteRM);
    }

    @Override
    public void update(Site model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE site SET (nom,description,profil,roche,type,coordonnees_gps) = (?,?,?,?,?,?) WHERE id = ?;",
                model.getNom(),
                model.getDescription(),
                model.getProfil(),
                model.getRoche(),
                model.getType(),
                model.getCoordonneesGPS(),
                model.getId()
        );
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM site WHERE id = ? ;", id);
    }
}
