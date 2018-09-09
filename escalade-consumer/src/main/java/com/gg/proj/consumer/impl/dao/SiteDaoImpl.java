package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.SiteDao;
import com.gg.proj.model.bean.Site;
import org.postgresql.geometric.PGpoint;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

    @Override
    public void create(Site model) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("INSERT INTO site (nom, description, profils, roche, type, coordonnees_gps) VALUES (?,?,?,?,?,?);",
                model.getNom(),
                model.getDescription(),
                model.getProfils(),
                model.getRoche(),
                model.getType(),
                model.getCoordonneesGPS()
        );
    }

    @Override
    public Site get(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM site WHERE id = ?;",
                (rs, rowNum) -> {
                    Site s = new Site();
                    s.setId(rs.getInt("id"));
                    s.setNom(rs.getString("nom"));
                    s.setDescription(rs.getString("description"));
                    s.setProfils(rs.getString("profils"));
                    s.setRoche(rs.getString("roche"));
                    s.setType(rs.getString("type"));
                    s.setCoordonneesGPS((PGpoint) rs.getObject("coordonnees_gps"));
                    return s;
                },
                id);
    }

    @Override
    public List<Site> list() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM site;",
                (rs, rowNum) -> {
                    Site s = new Site();
                    s.setId(rs.getInt("id"));
                    s.setNom(rs.getString("nom"));
                    s.setDescription(rs.getString("description"));
                    s.setProfils(rs.getString("profils"));
                    s.setRoche(rs.getString("roche"));
                    s.setType(rs.getString("type"));
                    s.setCoordonneesGPS((PGpoint) rs.getObject("coordonnees_gps"));
                    return s;
                });
    }

    @Override
    public void update(Site model) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE site SET (nom,description,profils,roche,type,coordonnees_gps) = (?,?,?,?,?,?) WHERE id = ?;",
                model.getNom(),
                model.getDescription(),
                model.getProfils(),
                model.getRoche(),
                model.getType(),
                model.getCoordonneesGPS(),
                model.getId()
        );
    }

    @Override
    public void delete(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM site WHERE id = ?;", id);
    }
}
