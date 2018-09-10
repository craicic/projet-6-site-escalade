package com.gg.proj.consumer.impl.dao;

import com.gg.proj.consumer.contract.dao.EmpreintDao;
import com.gg.proj.model.bean.Empreint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class EmpreintDaoImpl extends AbstractDaoImpl implements EmpreintDao {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void create(Empreint model) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTempplate = new JdbcTemplate(getDataSource());
        jdbcTempplate.update("INSERT INTO empreint (date_empreint, date_retour, utilisateur_id) VALUES(?, ?, ?);",
                model.getDateEmpreint(),
                model.getDateRetour(),
                model.getUtilisateurId()
        );
    }

    @Override
    public Empreint get(int id) {
        logger.debug("Entrée dans la méthode get avec l'id " + id);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.queryForObject("SELECT * FROM empreint WHERE id = ?;", (rs, rowNum) -> {
                    Empreint empreint = new Empreint();
                    empreint.setId(rs.getInt("id"));
                    empreint.setDateEmpreint(rs.getDate("date_empreint"));
                    empreint.setDateRetour(rs.getDate("date_retour"));
                    empreint.setUtilisateurId(rs.getInt("utilisateur_id"));
                    return empreint;
                },
                id);
    }

    @Override
    public List<Empreint> list() {
        logger.debug("Entrée dans la méthode list");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate.query("SELECT * FROM empreint;",
                (rs, rowNum) -> {
                    Empreint empreint = new Empreint();
                    empreint.setId(rs.getInt("id"));
                    empreint.setDateEmpreint(rs.getDate("date_empreint"));
                    empreint.setDateRetour(rs.getDate("date_retour"));
                    empreint.setUtilisateurId(rs.getInt("utilisateur_id"));
                    return empreint;
                });
    }

    @Override
    public void update(Empreint model) {
        logger.debug("Entrée dans la méthode update");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("UPDATE empreint SET (date_empreint,date_retour,utilisateur_id) = (?,?,?) WHERE id = ?;",
                model.getDateEmpreint(),
                model.getDateRetour(),
                model.getUtilisateurId(),
                model.getId());
    }

    @Override
    public void delete(Integer id) {
        logger.debug("Entrée dans la méthode create");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update("DELETE FROM empreint WHERE id = ?;", id);
    }
}
