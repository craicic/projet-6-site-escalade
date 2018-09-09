package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.TopoDao;
import com.gg.proj.model.bean.Topo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
//@Singleton
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Topo model) {
        logger.debug("Entrée dans la méthode create");
        Topo topo = (Topo) model;
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO topo (auteur, titre, description) VALUES(?, ?, ?);",
                topo.getAuteur(),
                topo.getTitre(),
                topo.getDescription()
        );
    }

    // todo : question faut-il utiliser Object ou Topo
    @Override
    public Topo get(int id) {
        logger.debug("Entrée dans la méthode get avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Topo topo = jdbcTemplate.queryForObject("SELECT * FROM topo WHERE id = ?;",
                // RowMapper<T> ecrit via lambda
                (rs, rowNum) -> {
                    Topo t = new Topo();
                    t.setId(rs.getInt("id"));
                    t.setTitre(rs.getString("Titre"));
                    t.setAuteur(rs.getString("Auteur"));
                    t.setDescription(rs.getString("Description"));
                    return t;
                },
                id // Paramètre '?' de la requête
        );
        return topo;
    }

    @Override
    public List list() {
        logger.debug("Entrée dans la méthode list");
        List<Topo> topos;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        topos = jdbcTemplate.query("SELECT * FROM topo;",
                (rs, rowNum) -> {
                    Topo t = new Topo();
                    t.setId(rs.getInt("id"));
                    t.setTitre(rs.getString("Titre"));
                    t.setAuteur(rs.getString("Auteur"));
                    t.setDescription(rs.getString("Description"));
                    return t;
                });
        return topos;
    }

    @Override
    public void update(Topo model) {
        logger.debug("Entrée dans la méthode update");
        Topo topo = (Topo) model;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE topo SET (auteur, titre, description) = (?,?,?) WHERE id = ? ;",
                topo.getAuteur(),
                topo.getTitre(),
                topo.getDescription(),
                topo.getId()
        );

    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM topo WHERE id = ?;", id);
    }
}
